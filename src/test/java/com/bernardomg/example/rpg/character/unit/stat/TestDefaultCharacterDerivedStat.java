
package com.bernardomg.example.rpg.character.unit.stat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.example.rpg.character.Character;
import com.bernardomg.example.rpg.character.builder.DefaultCharacterBuilder;
import com.bernardomg.example.rpg.character.stat.MultipliedDerivedStat;
import com.bernardomg.example.rpg.constants.DefaultStats;

@RunWith(JUnitPlatform.class)
public final class TestDefaultCharacterDerivedStat {

    private final Character character;

    public TestDefaultCharacterDerivedStat() {
        super();

        character = new DefaultCharacterBuilder()
                .withAttribute(DefaultStats.STRENGTH.getKey())
                .withMultipliedDerivedAttribute(DefaultStats.DAMAGE.getKey(),
                        DefaultStats.STRENGTH.getKey(), 2)
                .get();
    }

    @Test
    public final void testDerived() {
        character.setStatValue(DefaultStats.STRENGTH.getKey(), 2);

        Assertions.assertEquals((Integer) 4,
                character.getStatValue(DefaultStats.DAMAGE.getKey()));
    }

    @Test
    public final void testDerived_ChangeBase_ChangesDerived() {
        character.setStatValue(DefaultStats.STRENGTH.getKey(), 2);

        Assertions.assertEquals((Integer) 4,
                character.getStatValue(DefaultStats.DAMAGE.getKey()));

        character.setStatValue(DefaultStats.STRENGTH.getKey(), 4);

        Assertions.assertEquals((Integer) 8,
                character.getStatValue(DefaultStats.DAMAGE.getKey()));
    }

    @Test
    public final void testDerived_ChangeFunction_ChangesDerived() {
        character.setStatValue(DefaultStats.STRENGTH.getKey(), 2);

        Assertions.assertEquals((Integer) 4,
                character.getStatValue(DefaultStats.DAMAGE.getKey()));

        character.setStat(DefaultStats.DAMAGE.getKey(),
                new MultipliedDerivedStat(DefaultStats.STRENGTH.getKey(), 3));

        Assertions.assertEquals((Integer) 6,
                character.getStatValue(DefaultStats.DAMAGE.getKey()));
    }

}
