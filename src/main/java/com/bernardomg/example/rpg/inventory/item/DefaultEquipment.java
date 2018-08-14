
package com.bernardomg.example.rpg.inventory.item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import com.bernardomg.example.rpg.stat.Stat;
import com.bernardomg.example.rpg.stat.store.DefaultStatStore;
import com.bernardomg.example.rpg.stat.store.StatStore;
import com.google.common.collect.Iterables;

public final class DefaultEquipment implements Equipment {

    private final Collection<String> properties = new HashSet<>();

    private final Collection<String> slots      = new ArrayList<>();

    private final StatStore          statStore  = new DefaultStatStore();

    public DefaultEquipment() {
        super();
    }

    @Override
    public final void addProperty(final String name) {
        properties.add(name);
    }

    @Override
    public final Collection<String> getProperties() {
        return Collections.unmodifiableCollection(properties);
    }

    @Override
    public final Iterable<String> getSlots() {
        return slots;
    }

    @Override
    public final Collection<String> getStatKeys() {
        return statStore.getStatKeys();
    }

    @Override
    public final Integer getStatValue(final String stat) {
        return statStore.getStatValue(stat);
    }

    @Override
    public final Boolean hasProperty(final String name) {
        return properties.contains(name);
    }

    @Override
    public final Boolean hasStat(final String stat) {
        return statStore.hasStat(stat);
    }

    @Override
    public final void removeProperty(final String name) {
        properties.remove(name);
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
