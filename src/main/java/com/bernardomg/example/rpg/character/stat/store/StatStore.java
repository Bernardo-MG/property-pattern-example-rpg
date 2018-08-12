
package com.bernardomg.example.rpg.character.stat.store;

import java.util.Collection;

import com.bernardomg.example.rpg.character.stat.Stat;

public interface StatStore {

    public Collection<String> getStatNames();

    public Integer getStatValue(final String name);

    public Boolean hasStat(final String name);

    public void removeStat(final String name);

    public void setStat(final String name, final Stat value);

    public void setStatValue(final String name, final Integer value);

}
