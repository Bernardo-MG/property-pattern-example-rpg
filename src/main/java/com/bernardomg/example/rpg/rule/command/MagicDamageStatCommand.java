
package com.bernardomg.example.rpg.rule.command;

import com.bernardomg.example.rpg.command.Command;
import com.bernardomg.example.rpg.constants.DefaultStats;
import com.bernardomg.example.rpg.stat.MultipliedDerivedStat;
import com.bernardomg.example.rpg.stat.store.StatStore;

public class MagicDamageStatCommand implements Command<StatStore> {

    public MagicDamageStatCommand() {
        super();
    }

    @Override
    public void apply(final StatStore target) {
        target.setStat(DefaultStats.DAMAGE.getKey(), new MultipliedDerivedStat(
                DefaultStats.INTELLIGENCE.getKey(), 2));
    }

    @Override
    public void undo(final StatStore target) {
        target.setStat(DefaultStats.DAMAGE.getKey(),
                new MultipliedDerivedStat(DefaultStats.STRENGTH.getKey(), 2));
    }

    @Override
    public final Boolean valid(final StatStore target) {
        return true;
    }

}
