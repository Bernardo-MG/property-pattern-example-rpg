
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
    private final void testDamage() {
        final Character character;

        character = new DefaultCharacter();

        character.setStrength(2);

        Assertions.assertEquals((Integer) 4, character.getDamage());
    }

    @Test
    private final void testMana() {
        final Character character;

        character = new DefaultCharacter();

        character.setIntelligence(10);

        Assertions.assertEquals((Integer) 10, character.getMana());
    }

}
