
package com.bernardomg.example.rpg.stat;

public final class MultiplyDerivedStat implements DerivedStat {

    private final Integer     multiplier;

    private final DerivedStat wrappedStat;

    public MultiplyDerivedStat(final String att, final Integer mult) {
        super();

        multiplier = mult;
        wrappedStat = new FunctionDerivedStat(att, this::getMultipliedValue);
    }

    @Override
    public final String getStat() {
        return wrappedStat.getStat();
    }

    @Override
    public final Integer getValue(final Stat stat) {
        return wrappedStat.getValue(stat);
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
