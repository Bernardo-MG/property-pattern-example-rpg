
package com.bernardomg.example.rpg.character.property;

import com.bernardomg.example.rpg.character.constants.DefaultStats;
import com.bernardomg.example.rpg.character.stat.MultipliedDerivedStat;
import com.bernardomg.example.rpg.character.stat.store.StatStore;

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
