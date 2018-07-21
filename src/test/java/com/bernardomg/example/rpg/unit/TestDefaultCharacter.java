
package com.bernardomg.example.rpg.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.example.rpg.character.Character;
import com.bernardomg.example.rpg.character.DefaultCharacter;

@RunWith(JUnitPlatform.class)
public final class TestDefaultCharacter {

    public TestDefaultCharacter() {
        super();
    }

    @Test
    public final void testDamage() {
        final Character character;

        character = new DefaultCharacter();

        character.setStrength(2);

        Assertions.assertEquals((Integer) 4, character.getDamage());
    }

    @Test
    public final void testDamage_ChangeBase_ChangesDerived() {
        final Character character;

        character = new DefaultCharacter();

        character.setStrength(2);

        Assertions.assertEquals((Integer) 4, character.getDamage());

        character.setStrength(4);

        Assertions.assertEquals((Integer) 8, character.getDamage());
    }

    @Test
    public final void testMana() {
        final Character character;

        character = new DefaultCharacter();

        character.setIntelligence(10);

        Assertions.assertEquals((Integer) 10, character.getMana());
    }

}
