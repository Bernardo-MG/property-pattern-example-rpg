
package com.bernardomg.example.rpg.character.unit.factory;

import com.bernardomg.example.rpg.builder.character.CharacterBuilder;
import com.bernardomg.example.rpg.builder.character.DefaultCharacterBuilder;
import com.bernardomg.example.rpg.character.Character;
import com.bernardomg.example.rpg.constants.DefaultAbilities;
import com.bernardomg.example.rpg.constants.DefaultItemSlots;
import com.bernardomg.example.rpg.constants.DefaultProperties;
import com.bernardomg.example.rpg.constants.DefaultStats;
import com.bernardomg.example.rpg.rule.command.EquipTwoHandedCommand;
import com.bernardomg.example.rpg.rule.command.MagicDamageStatCommand;

public final class TestCharacterFactory {

    public static final Character getDefaultCharacter() {
        return getDefaultCharacterBuilder().get();
    }

    public static final Character getMagicCharacter() {
        return getDefaultCharacterBuilder()
                .registerProperty(DefaultAbilities.MAGIC_DAMAGE.getKey(),
                        new MagicDamageStatCommand())
                .get();
    }

    private static final CharacterBuilder getDefaultCharacterBuilder() {
        return new DefaultCharacterBuilder()
                .withAttribute(DefaultStats.STRENGTH.getKey())
                .withAttribute(DefaultStats.INTELLIGENCE.getKey())
                .withMultipliedDerivedAttribute(DefaultStats.DAMAGE.getKey(),
                        DefaultStats.STRENGTH.getKey(), 2)
                .withItemSlot(DefaultItemSlots.MAIN_HAND.getKey())
                .withItemSlot(DefaultItemSlots.OFF_HAND.getKey())
                .withItemSlot(DefaultItemSlots.BACK.getKey())
                .registerProperty(DefaultProperties.TWO_HANDED.getKey(),
                        new EquipTwoHandedCommand());
    }

    private TestCharacterFactory() {
        super();
    }

}
