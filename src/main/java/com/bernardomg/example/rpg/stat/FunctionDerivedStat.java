
package com.bernardomg.example.rpg.stat;

import java.util.function.Function;

public final class FunctionDerivedStat implements Stat {

    private final Function<Stat, Integer> function;

    private final Stat                    stat;

    public FunctionDerivedStat(final Stat stat,
            final Function<Stat, Integer> func) {
        super();

        this.stat = stat;
        function = func;
    }

    @Override
    public final Integer getValue() {
        return function.apply(stat);
    }

}
