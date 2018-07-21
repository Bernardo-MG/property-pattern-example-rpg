
package com.bernardomg.example.rpg.character.stat.store;

import java.util.HashMap;
import java.util.Map;

import com.bernardomg.example.rpg.character.stat.DerivedStat;
import com.bernardomg.example.rpg.character.stat.Stat;
import com.bernardomg.example.rpg.character.stat.ValueStat;

public final class DefaultStatStore implements StatStore {

    private final Map<String, Stat> stats = new HashMap<>();

    public DefaultStatStore() {
        super();
    }

    @Override
    public final Integer getStatValue(final String stat) {
        final Stat found;
        final Stat mainStat;
        final DerivedStat derived;
        final Integer value;

        found = stats.get(stat);

        if (found instanceof ValueStat) {
            value = ((ValueStat) found).getValue();
        } else if (found instanceof DerivedStat) {
            derived = ((DerivedStat) found);
            if (stats.containsKey(derived.getStat())) {
                mainStat = stats.get(derived.getStat());
                value = derived.getValue(mainStat);
            } else {
                value = 0;
            }
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
