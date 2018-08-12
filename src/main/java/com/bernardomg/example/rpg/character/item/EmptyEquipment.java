
package com.bernardomg.example.rpg.character.item;

import java.util.Collection;
import java.util.Collections;

import com.bernardomg.example.rpg.character.stat.Stat;

public class EmptyEquipment implements Equipment {

    public EmptyEquipment() {
        super();
    }

    @Override
    public void addProperty(final String name) {}

    @Override
    public Collection<String> getProperties() {
        return Collections.emptyList();
    }

    @Override
    public Iterable<String> getSlots() {
        return Collections.emptyList();
    }

    @Override
    public Collection<String> getStatNames() {
        return Collections.emptyList();
    }

    @Override
    public Integer getStatValue(final String name) {
        return 0;
    }

    @Override
    public Boolean hasProperty(final String name) {
        return false;
    }

    @Override
    public Boolean hasStat(final String name) {
        return false;
    }

    @Override
    public void removeProperty(final String name) {}

    @Override
    public void removeStat(final String name) {}

    @Override
    public void setSlots(final Iterable<String> slots) {}

    @Override
    public void setStat(final String name, final Stat value) {}

    @Override
    public void setStatValue(final String name, final Integer value) {}

}
