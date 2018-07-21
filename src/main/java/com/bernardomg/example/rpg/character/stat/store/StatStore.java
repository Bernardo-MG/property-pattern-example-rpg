
package com.bernardomg.example.rpg.character.stat.store;

import java.util.Collection;

import com.bernardomg.example.rpg.character.stat.Stat;

public interface StatStore {

    public Collection<String> getStatNames();

    public Integer getStatValue(final String stat);

    public Boolean hasStat(final String stat);

    public void removeStat(final String stat);

    public void setStat(final String stat, final Stat value);

    public void setStatValue(final String stat, final Integer value);

}
