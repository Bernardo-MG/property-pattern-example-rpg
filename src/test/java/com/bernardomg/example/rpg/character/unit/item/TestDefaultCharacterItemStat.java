
package com.bernardomg.example.rpg.character.unit.item;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.example.rpg.character.Character;
import com.bernardomg.example.rpg.character.builder.DefaultCharacterBuilder;
import com.bernardomg.example.rpg.character.constants.DefaultItemSlots;
import com.bernardomg.example.rpg.character.constants.DefaultStats;
import com.bernardomg.example.rpg.character.item.Equipment;
import com.bernardomg.example.rpg.character.item.builder.DefaultItemBuilder;

@RunWith(JUnitPlatform.class)
public final class TestDefaultCharacterItemStat {

    private final Character character;

    private final Equipment swordBig;

    private final Equipment swordSmall;

    public TestDefaultCharacterItemStat() {
        super();

        character = new DefaultCharacterBuilder()
                .withAttribute(DefaultStats.STRENGTH.getKey())
                .withMultipliedDerivedAttribute(DefaultStats.DAMAGE.getKey(),
                        DefaultStats.STRENGTH.getKey(), 2)
                .withItemSlot(DefaultItemSlots.MAIN_HAND.getKey()).get();

        swordSmall = new DefaultItemBuilder().equipment()
                .withSlots(Arrays.asList(DefaultItemSlots.MAIN_HAND.getKey(),
                        DefaultItemSlots.OFF_HAND.getKey()))
                .withAttribute(DefaultStats.DAMAGE.getKey(), 5).get();
        swordBig = new DefaultItemBuilder().equipment()
                .withSlots(Arrays.asList(DefaultItemSlots.MAIN_HAND.getKey(),
                        DefaultItemSlots.OFF_HAND.getKey()))
                .withAttribute(DefaultStats.DAMAGE.getKey(), 10).get();
    }

    @Test
    public final void testDerived_ReplaceEquipment() {
        character.setStatValue(DefaultStats.STRENGTH.getKey(), 2);
        character.addEquipment(DefaultItemSlots.MAIN_HAND.getKey(), swordSmall);
        character.addEquipment(DefaultItemSlots.MAIN_HAND.getKey(), swordBig);

        Assertions.assertEquals((Integer) 14,
                character.getStatValue(DefaultStats.DAMAGE.getKey()));
    }

    @Test
    public final void testDerived_WithEquipment() {
        character.setStatValue(DefaultStats.STRENGTH.getKey(), 2);
        character.addEquipment(DefaultItemSlots.MAIN_HAND.getKey(), swordSmall);

        Assertions.assertEquals((Integer) 9,
                character.getStatValue(DefaultStats.DAMAGE.getKey()));
    }

}
