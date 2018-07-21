
package com.bernardomg.example.rpg.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.example.rpg.character.Character;
import com.bernardomg.example.rpg.character.DefaultCharacter;
import com.bernardomg.example.rpg.character.attribute.Stats;

@RunWith(JUnitPlatform.class)
public final class TestDefaultCharacter {

    public TestDefaultCharacter() {
        super();
    }

    @Test
    public final void testDamage() {
        final Character character;

        character = new DefaultCharacter();

        character.setAttribute(Stats.STRENGTH.getKey(), 2);

        Assertions.assertEquals((Integer) 4,
                character.getAttribute(Stats.DAMAGE.getKey()));
    }

    @Test
    public final void testDamage_ChangeBase_ChangesDerived() {
        final Character character;

        character = new DefaultCharacter();

        character.setAttribute(Stats.STRENGTH.getKey(), 2);

        Assertions.assertEquals((Integer) 4,
                character.getAttribute(Stats.DAMAGE.getKey()));

        character.setAttribute(Stats.STRENGTH.getKey(), 4);

        Assertions.assertEquals((Integer) 8,
                character.getAttribute(Stats.DAMAGE.getKey()));
    }

    @Test
    public final void testMana() {
        final Character character;

        character = new DefaultCharacter();

        character.setAttribute(Stats.INTELLIGENCE.getKey(), 10);

        Assertions.assertEquals((Integer) 10,
                character.getAttribute(Stats.MANA.getKey()));
    }

}
