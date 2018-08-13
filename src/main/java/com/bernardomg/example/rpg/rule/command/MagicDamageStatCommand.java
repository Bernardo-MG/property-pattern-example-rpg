
package com.bernardomg.example.rpg.rule.command;

import com.bernardomg.example.rpg.command.Command;
import com.bernardomg.example.rpg.constants.DefaultStats;
import com.bernardomg.example.rpg.stat.MultiplyDerivedStat;
import com.bernardomg.example.rpg.stat.store.StatStore;

public class MagicDamageStatCommand implements Command {

    public MagicDamageStatCommand() {
        super();
    }

    @Override
    public void apply(final Object target) {
        ((StatStore) target).setStat(DefaultStats.DAMAGE.getKey(),
                new MultiplyDerivedStat(DefaultStats.INTELLIGENCE.getKey(), 2));
    }

    @Override
    public void undo(final Object target) {
        ((StatStore) target).setStat(DefaultStats.DAMAGE.getKey(),
                new MultiplyDerivedStat(DefaultStats.STRENGTH.getKey(), 2));
    }

    @Override
    public final Boolean valid(final Object target) {
        return (target instanceof StatStore);
    }

}
