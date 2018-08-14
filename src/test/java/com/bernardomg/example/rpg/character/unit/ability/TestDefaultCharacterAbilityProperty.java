
package com.bernardomg.example.rpg.character.unit.ability;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.example.rpg.ability.Ability;
import com.bernardomg.example.rpg.ability.DefaultAbility;
import com.bernardomg.example.rpg.character.Character;
import com.bernardomg.example.rpg.character.unit.factory.TestCharacterFactory;
import com.bernardomg.example.rpg.constants.DefaultAbilities;
import com.bernardomg.example.rpg.constants.DefaultStats;

@RunWith(JUnitPlatform.class)
public final class TestDefaultCharacterAbilityProperty {

    private final Character character;

    private final Ability   emptyAbility;

    private final Ability   magicDamageAbility;

    public TestDefaultCharacterAbilityProperty() {
        super();

        character = TestCharacterFactory.getMagicCharacter();

        magicDamageAbility = new DefaultAbility(
                DefaultAbilities.MAGIC_DAMAGE.getKey());
        magicDamageAbility.addProperty(DefaultAbilities.MAGIC_DAMAGE.getKey());

        emptyAbility = new DefaultAbility(
                DefaultAbilities.PLACEHOLDER.getKey());
    }

    @Test
    public final void testDerived_AddAbility_ChangesDerived() {
        character.setStatValue(DefaultStats.STRENGTH.getKey(), 2);
        character.setStatValue(DefaultStats.INTELLIGENCE.getKey(), 5);

        character.addAbility(magicDamageAbility);

        Assertions.assertEquals((Integer) 10,
                character.getStatValue(DefaultStats.DAMAGE.getKey()));
    }

    @Test
    public final void testDerived_RemoveAbility_DerivedRecovered() {
        character.setStatValue(DefaultStats.STRENGTH.getKey(), 2);
        character.setStatValue(DefaultStats.INTELLIGENCE.getKey(), 5);

        character.addAbility(magicDamageAbility);

        character.removeAbility(magicDamageAbility);

        Assertions.assertEquals((Integer) 4,
                character.getStatValue(DefaultStats.DAMAGE.getKey()));
    }

    @Test
    public final void testDerived_RemoveAnotherAbility_DerivedKept() {
        character.setStatValue(DefaultStats.STRENGTH.getKey(), 2);
        character.setStatValue(DefaultStats.INTELLIGENCE.getKey(), 5);

        character.addAbility(magicDamageAbility);

        character.removeAbility(emptyAbility);

        Assertions.assertEquals((Integer) 10,
                character.getStatValue(DefaultStats.DAMAGE.getKey()));
    }

}
