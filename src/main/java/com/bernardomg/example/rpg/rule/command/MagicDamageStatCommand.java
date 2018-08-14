
package com.bernardomg.example.rpg.rule.command;

import com.bernardomg.example.rpg.command.Command;
import com.bernardomg.example.rpg.constants.DefaultStats;
import com.bernardomg.example.rpg.stat.MultiplyDerivedStat;
import com.bernardomg.example.rpg.stat.Stat;
import com.bernardomg.example.rpg.stat.store.StatStore;

public class MagicDamageStatCommand implements Command {

    public MagicDamageStatCommand() {
        super();
    }

    @Override
    public void apply(final Object target) {
        final StatStore store;
        final Stat stat;

        store = (StatStore) target;

        stat = store.getStat(DefaultStats.INTELLIGENCE.getKey());

        store.setStat(DefaultStats.DAMAGE.getKey(),
                new MultiplyDerivedStat(stat, 2));
    }

    @Override
    public void undo(final Object target) {
        final StatStore store;
        final Stat stat;

        store = (StatStore) target;

        stat = store.getStat(DefaultStats.STRENGTH.getKey());

        ((StatStore) target).setStat(DefaultStats.DAMAGE.getKey(),
                new MultiplyDerivedStat(stat, 2));
    }

    @Override
    public final Boolean valid(final Object target) {
        return (target instanceof StatStore);
    }

}
