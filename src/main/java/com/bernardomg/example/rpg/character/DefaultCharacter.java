
package com.bernardomg.example.rpg.character;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.bernardomg.example.rpg.ability.Ability;
import com.bernardomg.example.rpg.inventory.item.Equipment;
import com.bernardomg.example.rpg.inventory.slot.CharacterItemSlot;
import com.bernardomg.example.rpg.inventory.slot.ItemSlot;
import com.bernardomg.example.rpg.inventory.slot.WrapperCharacterItemSlot;
import com.bernardomg.example.rpg.inventory.slot.store.DefaultItemSlotStore;
import com.bernardomg.example.rpg.inventory.slot.store.ItemSlotStore;
import com.bernardomg.example.rpg.property.PropertyExecutor;
import com.bernardomg.example.rpg.stat.Stat;
import com.bernardomg.example.rpg.stat.store.DefaultStatStore;
import com.bernardomg.example.rpg.stat.store.StatStore;

public final class DefaultCharacter implements Character {

    private final Collection<Ability> abilities     = new ArrayList<>();

    private final ItemSlotStore       itemSlotStore = new DefaultItemSlotStore();

    private final PropertyExecutor    propertyExecutor;

    private final StatStore           statStore     = new DefaultStatStore();

    public DefaultCharacter(final PropertyExecutor propTransformer) {
        super();

        propertyExecutor = propTransformer;
    }

    @Override
    public final void addAbility(final Ability ability) {
        abilities.add(ability);

        applyProperties(ability);
    }

    @Override
    public final void addItemSlot(final ItemSlot slot) {
        itemSlotStore.addItemSlot(slot);
    }

    @Override
    public final Boolean addToItemSlot(final String slot,
            final Equipment item) {
        final ItemSlot itemSlot;
        final Boolean added;

        added = itemSlotStore.addToItemSlot(slot, item);

        if (added) {
            itemSlot = itemSlotStore.getItemSlot(slot);
            applyProperties(itemSlot);
        }

        return added;
    }

    @Override
    public final void clearSlot(final String slot) {
        final ItemSlot itemSlot;

        itemSlot = itemSlotStore.getItemSlot(slot);
        removeProperties(itemSlot);

        itemSlotStore.clearSlot(slot);
    }

    @Override
    public final Iterable<Ability> getAbilities() {
        return Collections.unmodifiableCollection(abilities);
    }

    @Override
    public final ItemSlot getItemSlot(final String slot) {
        return itemSlotStore.getItemSlot(slot);
    }

    @Override
    public final Collection<ItemSlot> getItemSlots() {
        return itemSlotStore.getItemSlots();
    }

    @Override
    public final Collection<String> getStatNames() {
        return statStore.getStatNames();
    }

    @Override
    public final Integer getStatValue(final String stat) {
        final Integer baseVal;
        final Integer itemVal;

        baseVal = statStore.getStatValue(stat);
        itemVal = itemSlotStore.getItemSlots().stream().map(ItemSlot::getItem)
                .filter((e) -> e.hasStat(stat)).map((e) -> e.getStatValue(stat))
                .reduce(0, (a, b) -> a + b);

        return baseVal + itemVal;
    }

    @Override
    public final Boolean hasStat(final String stat) {
        return statStore.hasStat(stat);
    }

    @Override
    public final void removeAbility(final Ability ability) {
        abilities.remove(ability);

        removeProperties(ability);
    }

    @Override
    public final void removeItemSlot(final String slot) {
        clearSlot(slot);
        itemSlotStore.removeItemSlot(slot);
    }

    @Override
    public final void removeStat(final String stat) {
        statStore.removeStat(stat);
    }

    @Override
    public final void setStat(final String stat, final Stat value) {
        statStore.setStat(stat, value);
    }

    @Override
    public final void setStatValue(final String stat, final Integer value) {
        statStore.setStatValue(stat, value);
    }

    private final void applyProperties(final Ability ability) {
        ability.getProperties().stream()
                .forEach((p) -> propertyExecutor.apply(p, statStore));
    }

    private final void applyProperties(final ItemSlot slot) {
        final CharacterItemSlot event;

        event = new WrapperCharacterItemSlot(this, slot);

        slot.getItem().getProperties().stream()
                .forEach((p) -> propertyExecutor.apply(p, event));
    }

    private final void removeProperties(final Ability ability) {
        ability.getProperties().stream()
                .forEach((p) -> propertyExecutor.undo(p, statStore));
    }

    private final void removeProperties(final ItemSlot slot) {
        final CharacterItemSlot event;

        event = new WrapperCharacterItemSlot(this, slot);

        slot.getItem().getProperties().stream()
                .forEach((p) -> propertyExecutor.undo(p, event));
    }

}
