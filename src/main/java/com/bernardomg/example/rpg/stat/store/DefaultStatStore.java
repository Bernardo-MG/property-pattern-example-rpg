
package com.bernardomg.example.rpg.stat.store;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.bernardomg.example.rpg.stat.Stat;
import com.bernardomg.example.rpg.stat.ValueStat;

public final class DefaultStatStore implements StatStore {

    private final Map<String, Stat> stats = new HashMap<>();

    public DefaultStatStore() {
        super();
    }

    @Override
    public final Stat getStat(final String name) {
        return stats.get(name);
    }

    @Override
    public final Collection<String> getStatKeys() {
        return Collections.unmodifiableCollection(stats.keySet());
    }

    @Override
    public final Integer getStatValue(final String stat) {
        final Stat found;
        final Integer value;

        if (stats.containsKey(stat)) {
            found = stats.get(stat);

            value = found.getValue();
        } else {
            value = 0;
        }

        return value;
    }

    @Override
    public final Boolean hasStat(final String stat) {
        return stats.containsKey(stat);
    }

    @Override
    public final void removeStat(final String stat) {
        stats.remove(stat);
    }

    @Override
    public final void setStat(final String stat, final Stat value) {
        stats.put(stat, value);
    }

    @Override
    public final void setStatValue(final String stat, final Integer value) {
        final Stat found;

        found = stats.get(stat);

        if (found instanceof ValueStat) {
            ((ValueStat) found).setValue(value);
        }
    }

}
