
package com.bernardomg.example.rpg.character.property;

import com.bernardomg.example.rpg.character.Character;
import com.bernardomg.example.rpg.character.constants.DefaultStats;
import com.bernardomg.example.rpg.character.stat.MultipliedDerivedStat;

public class MagicDamageStatCommand implements Command<Character> {

    public MagicDamageStatCommand() {
        super();
    }

    @Override
    public void apply(final Character target) {
        target.setStat(DefaultStats.DAMAGE.getKey(), new MultipliedDerivedStat(
                DefaultStats.INTELLIGENCE.getKey(), 2));
    }

    @Override
    public void undo(final Character target) {
        target.setStat(DefaultStats.DAMAGE.getKey(),
                new MultipliedDerivedStat(DefaultStats.STRENGTH.getKey(), 2));
    }

}
