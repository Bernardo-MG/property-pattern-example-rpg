
package com.bernardomg.example.rpg.character;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.StreamSupport;

import com.bernardomg.example.rpg.character.ability.Ability;
import com.bernardomg.example.rpg.character.event.equipment.EquipItemEvent;
import com.bernardomg.example.rpg.character.item.EmptyEquipment;
import com.bernardomg.example.rpg.character.item.Equipment;
import com.bernardomg.example.rpg.character.slot.item.ItemSlot;
import com.bernardomg.example.rpg.character.stat.Stat;
import com.bernardomg.example.rpg.character.stat.store.DefaultStatStore;
import com.bernardomg.example.rpg.character.stat.store.StatStore;
import com.bernardomg.example.rpg.constants.DefaultEvents;
import com.bernardomg.example.rpg.event.DefaultEventHandler;
import com.bernardomg.example.rpg.event.EventHandler;
import com.bernardomg.example.rpg.event.EventInterceptor;
import com.bernardomg.example.rpg.property.PropertyExecutor;

public final class DefaultCharacter implements Character {

    private final Collection<Ability>  abilities    = new ArrayList<>();

    private final Collection<ItemSlot> equipment    = new ArrayList<>();

    private final EventHandler         eventHandler = new DefaultEventHandler();

    private final PropertyExecutor     propertyExecutor;

    private final StatStore            statStore    = new DefaultStatStore();

    public DefaultCharacter(final PropertyExecutor propTransformer) {
        super();

        propertyExecutor = propTransformer;
    }

    @Override
    public final void addAbility(final Ability ability) {
        abilities.add(ability);

        ability.getProperties().stream()
                .forEach((p) -> propertyExecutor.apply(p, statStore));
    }

    @Override
    public final void
            addEquipItemEventInterceptor(final EventInterceptor interceptor) {
        eventHandler.addEventInterceptor(DefaultEvents.EQUIP_ITEM.getKey(),
                interceptor);
    }

    @Override
    public final void addEquipment(final String slot, final Equipment item) {
        final Optional<ItemSlot> foundSlot;
        final ItemSlot itemSlot;
        final Boolean validSlot;

        validSlot = StreamSupport.stream(item.getSlots().spliterator(), false)
                .filter((s) -> s.equals(slot)).findAny().isPresent();

        if (validSlot) {
            foundSlot = equipment.stream()
                    .filter((s) -> s.getName().equals(slot)).findFirst();

            if (foundSlot.isPresent()) {
                itemSlot = foundSlot.get();
                itemSlot.setItem(item);

                fireEquipItemEvent(item, itemSlot);
            }
        }
    }

    @Override
    public final void addItemSlot(final ItemSlot slot) {
        equipment.add(slot);
    }

    @Override
    public final Iterable<Ability> getAbilities() {
        return Collections.unmodifiableCollection(abilities);
    }

    @Override
    public final Equipment getEquipment(final String slot) {
        final Optional<ItemSlot> foundSlot;
        final ItemSlot itemSlot;
        final Equipment result;

        foundSlot = equipment.stream().filter((s) -> s.getName().equals(slot))
                .findFirst();
        if (foundSlot.isPresent()) {
            itemSlot = foundSlot.get();
            result = itemSlot.getItem();
        } else {
            result = null;
        }

        return result;
    }

    @Override
    public final Iterable<ItemSlot> getItemSlots() {
        return Collections.unmodifiableCollection(equipment);
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
        itemVal = equipment.stream().map(ItemSlot::getItem)
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

        ability.getProperties().stream()
                .forEach((p) -> propertyExecutor.undo(p, statStore));
    }

    @Override
    public final void removeEquipment(final String slot) {
        final Optional<ItemSlot> foundSlot;
        final ItemSlot itemSlot;

        foundSlot = equipment.stream().filter((s) -> s.getName().equals(slot))
                .findFirst();
        if (foundSlot.isPresent()) {
            itemSlot = foundSlot.get();
            itemSlot.setItem(new EmptyEquipment());
        }
    }

    @Override
    public final void removeItemSlot(final ItemSlot slot) {
        equipment.remove(slot);
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

    private final void fireEquipItemEvent(final Equipment equipment,
            final ItemSlot slot) {
        final EquipItemEvent event;

        event = new EquipItemEvent(this, equipment, slot);

        eventHandler.fireEvent(DefaultEvents.EQUIP_ITEM.getKey(), event);
    }

}
