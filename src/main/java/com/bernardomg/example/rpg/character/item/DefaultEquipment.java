
package com.bernardomg.example.rpg.character.item;

import java.util.ArrayList;
import java.util.Collection;

import com.bernardomg.example.rpg.character.stat.Stat;
import com.bernardomg.example.rpg.character.stat.store.DefaultStatStore;
import com.bernardomg.example.rpg.character.stat.store.StatStore;
import com.google.common.collect.Iterables;

public final class DefaultEquipment implements Equipment {

    private final Collection<String> slots     = new ArrayList<>();

    private final StatStore          statStore = new DefaultStatStore();

    public DefaultEquipment() {
        super();
    }

    @Override
    public final Iterable<String> getSlots() {
        return slots;
    }

    @Override
    public final Collection<String> getStatNames() {
        return statStore.getStatNames();
    }

    @Override
    public final Integer getStatValue(final String stat) {
        return statStore.getStatValue(stat);
    }

    @Override
    public final Boolean hasStat(final String stat) {
        return statStore.hasStat(stat);
    }

    @Override
    public final void removeStat(final String stat) {
        statStore.removeStat(stat);
    }

    @Override
    public final void setSlots(final Iterable<String> slts) {
        slots.clear();

        Iterables.addAll(slots, slts);
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
