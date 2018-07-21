
package com.bernardomg.example.rpg.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.example.rpg.character.Character;
import com.bernardomg.example.rpg.character.attribute.DefaultStats;
import com.bernardomg.example.rpg.character.builder.DefaultCharacterBuilder;

@RunWith(JUnitPlatform.class)
public final class TestDefaultCharacter {

    private final Character character;

    public TestDefaultCharacter() {
        super();

        character = new DefaultCharacterBuilder()
                .withAttribute(DefaultStats.STRENGTH.getKey())
                .withMultipliedDerivedAttribute(DefaultStats.DAMAGE.getKey(),
                        DefaultStats.STRENGTH.getKey(), 2)
                .get();
    }

    @Test
    public final void testDerived() {
        character.setStat(DefaultStats.STRENGTH.getKey(), 2);

        Assertions.assertEquals((Integer) 4,
                character.getStat(DefaultStats.DAMAGE.getKey()));
    }

    @Test
    public final void testDerived_ChangeBase_ChangesDerived() {
        character.setStat(DefaultStats.STRENGTH.getKey(), 2);

        Assertions.assertEquals((Integer) 4,
                character.getStat(DefaultStats.DAMAGE.getKey()));

        character.setStat(DefaultStats.STRENGTH.getKey(), 4);

        Assertions.assertEquals((Integer) 8,
                character.getStat(DefaultStats.DAMAGE.getKey()));
    }

}
