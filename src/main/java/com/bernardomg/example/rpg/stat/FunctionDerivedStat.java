
package com.bernardomg.example.rpg.stat;

import java.util.function.Function;

public final class FunctionDerivedStat implements DerivedStat {

    private final String                  attribute;

    private final Function<Stat, Integer> function;

    public FunctionDerivedStat(final String att,
            final Function<Stat, Integer> func) {
        super();

        attribute = att;
        function = func;
    }

    @Override
    public final String getStat() {
        return attribute;
    }

    @Override
    public final Integer getValue(final Stat stat) {
        return function.apply(stat);
    }

}
