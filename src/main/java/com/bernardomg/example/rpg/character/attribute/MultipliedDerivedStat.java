
package com.bernardomg.example.rpg.character.attribute;

public final class MultipliedDerivedStat implements DerivedStat {

    private final Integer     multiplier;

    private final DerivedStat wrappedStat;

    public MultipliedDerivedStat(final String att, final Integer mult) {
        super();

        multiplier = mult;
        wrappedStat = new DefaultDerivedStat(att, this::getMultipliedValue);
    }

    @Override
    public final String getAttribute() {
        return wrappedStat.getAttribute();
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
