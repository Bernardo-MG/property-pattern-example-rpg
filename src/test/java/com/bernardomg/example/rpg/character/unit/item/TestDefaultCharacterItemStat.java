
package com.bernardomg.example.rpg.character.unit.item;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.example.rpg.character.Character;
import com.bernardomg.example.rpg.character.unit.factory.TestCharacterFactory;
import com.bernardomg.example.rpg.character.unit.factory.TestItemFactory;
import com.bernardomg.example.rpg.constants.DefaultItemSlots;
import com.bernardomg.example.rpg.constants.DefaultStats;
import com.bernardomg.example.rpg.inventory.item.Equipment;

@RunWith(JUnitPlatform.class)
public final class TestDefaultCharacterItemStat {

    private final Character character;

    private final Equipment swordBig;

    private final Equipment swordSmall;

    public TestDefaultCharacterItemStat() {
        super();

        character = TestCharacterFactory.getDefaultCharacter();

        swordSmall = TestItemFactory.getSmallSword();
        swordBig = TestItemFactory.getBigSword();
    }

    @Test
    public final void testDerived_ReplaceEquipment() {
        character.setStatValue(DefaultStats.STRENGTH.getKey(), 2);
        character.addToItemSlot(DefaultItemSlots.MAIN_HAND.getKey(),
                swordSmall);
        character.addToItemSlot(DefaultItemSlots.MAIN_HAND.getKey(), swordBig);

        Assertions.assertEquals((Integer) 14,
                character.getStatValue(DefaultStats.DAMAGE.getKey()));
    }

    @Test
    public final void testDerived_WithEquipment() {
        character.setStatValue(DefaultStats.STRENGTH.getKey(), 2);
        character.addToItemSlot(DefaultItemSlots.MAIN_HAND.getKey(),
                swordSmall);

        Assertions.assertEquals((Integer) 9,
                character.getStatValue(DefaultStats.DAMAGE.getKey()));
    }

}
