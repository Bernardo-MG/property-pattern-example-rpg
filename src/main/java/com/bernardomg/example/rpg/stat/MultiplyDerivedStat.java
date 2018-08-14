
package com.bernardomg.example.rpg.stat;

public final class MultiplyDerivedStat implements Stat {

    private final Integer multiplier;

    private final Stat    wrappedStat;

    public MultiplyDerivedStat(final Stat stat, final Integer mult) {
        super();

        multiplier = mult;
        wrappedStat = new FunctionDerivedStat(stat, this::getMultipliedValue);
    }

    @Override
    public final Integer getValue() {
        return wrappedStat.getValue();
    }

    private final Integer getMultipliedValue(final Stat stat) {
        final Integer value;

        if (stat instanceof ValueStat) {
            value = ((ValueStat) stat).getValue() * multiplier;
        } else {
            value = 0;
        }

        return value;
    }

}
