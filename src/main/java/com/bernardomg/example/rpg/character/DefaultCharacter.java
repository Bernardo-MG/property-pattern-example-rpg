
package com.bernardomg.example.rpg.character;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.bernardomg.example.rpg.character.item.Equipment;
import com.bernardomg.example.rpg.character.stat.Stat;
import com.bernardomg.example.rpg.character.stat.store.DefaultStatStore;
import com.bernardomg.example.rpg.character.stat.store.StatStore;

public final class DefaultCharacter implements Character {

    private final Collection<Ability>   abilities = new ArrayList<>();

    private final Collection<Equipment> equipment = new ArrayList<>();

    private final StatStore             statStore = new DefaultStatStore();

    public DefaultCharacter() {
        super();
    }

    @Override
    public final void addAbility(final Ability ability) {
        abilities.add(ability);
    }

    @Override
    public final void addEquipment(final Equipment item) {
        equipment.add(item);
    }

    @Override
    public final Iterable<Ability> getAbilities() {
        return Collections.unmodifiableCollection(abilities);
    }

    @Override
    public final Iterable<Equipment> getEquipment() {
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
        itemVal = equipment.stream().filter((e) -> e.hasStat(stat))
                .map((e) -> e.getStatValue(stat)).reduce(0, (a, b) -> a + b);

        return baseVal + itemVal;
    }

    @Override
    public final Boolean hasStat(final String stat) {
        return statStore.hasStat(stat);
    }

    @Override
    public final void removeAbility(final Ability ability) {
        abilities.remove(ability);
    }

    @Override
    public final void removeEquipment(final Equipment item) {
        equipment.remove(item);
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

}
