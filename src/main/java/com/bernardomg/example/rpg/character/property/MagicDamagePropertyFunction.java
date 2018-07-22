
package com.bernardomg.example.rpg.character.property;

import java.util.function.Consumer;

import com.bernardomg.example.rpg.character.Character;
import com.bernardomg.example.rpg.character.constants.DefaultStats;
import com.bernardomg.example.rpg.character.stat.MultipliedDerivedStat;

public class MagicDamagePropertyFunction implements Consumer<Character> {

    public MagicDamagePropertyFunction() {
        super();
    }

    @Override
    public void accept(final Character character) {
        character.setStat(DefaultStats.DAMAGE.getKey(),
                new MultipliedDerivedStat(DefaultStats.INTELLIGENCE.getKey(),
                        2));
    }

}
