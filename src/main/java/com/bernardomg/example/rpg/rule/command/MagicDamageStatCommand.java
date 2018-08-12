
package com.bernardomg.example.rpg.rule.command;

import com.bernardomg.example.rpg.character.stat.MultipliedDerivedStat;
import com.bernardomg.example.rpg.character.stat.store.StatStore;
import com.bernardomg.example.rpg.command.Command;
import com.bernardomg.example.rpg.constants.DefaultStats;

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

}
