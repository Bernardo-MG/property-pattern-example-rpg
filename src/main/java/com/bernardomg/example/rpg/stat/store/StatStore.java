
package com.bernardomg.example.rpg.stat.store;

import java.util.Collection;

import com.bernardomg.example.rpg.stat.Stat;

public interface StatStore {

    public Stat getStat(final String name);

    public Collection<String> getStatKeys();

    public Integer getStatValue(final String name);

    public Boolean hasStat(final String name);

    public void removeStat(final String name);

    public void setStat(final String name, final Stat value);

    public void setStatValue(final String name, final Integer value);

}
