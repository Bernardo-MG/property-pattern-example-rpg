
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
public final class TestDefaultCharacterItemSlot {

    private final Character character;

    private final Equipment swordBig;

    private final Equipment swordSmall;

    private final Equipment twoHanded;

    public TestDefaultCharacterItemSlot() {
        super();

        character = TestCharacterFactory.getDefaultCharacter();

        swordSmall = TestItemFactory.getSmallSword();
        swordBig = TestItemFactory.getBigSword();
        twoHanded = TestItemFactory.getTwoHandedSword();
    }

    @Test
    public final void testSlot_BothHands() {
        character.addToItemSlot(DefaultItemSlots.MAIN_HAND.getKey(),
                swordSmall);
        character.addToItemSlot(DefaultItemSlots.OFF_HAND.getKey(), swordBig);

        Assertions.assertEquals(swordSmall, character
                .getItemSlot(DefaultItemSlots.MAIN_HAND.getKey()).getItem());
        Assertions.assertEquals(swordBig, character
                .getItemSlot(DefaultItemSlots.OFF_HAND.getKey()).getItem());
    }

    @Test
    public final void testSlot_InvalidSlot() {
        character.addToItemSlot(DefaultItemSlots.ARMOR.getKey(), swordSmall);

        Assertions.assertNull(
                character.getItemSlot(DefaultItemSlots.ARMOR.getKey()));
    }

    @Test
    public final void testSlot_ReplaceEquipment() {
        character.addToItemSlot(DefaultItemSlots.MAIN_HAND.getKey(),
                swordSmall);
        character.addToItemSlot(DefaultItemSlots.MAIN_HAND.getKey(), swordBig);

        Assertions.assertEquals(swordBig, character
                .getItemSlot(DefaultItemSlots.MAIN_HAND.getKey()).getItem());
    }

    @Test
    public final void testSlot_TwoHanded() {
        character.addToItemSlot(DefaultItemSlots.MAIN_HAND.getKey(), twoHanded);

        Assertions.assertEquals(twoHanded, character
                .getItemSlot(DefaultItemSlots.MAIN_HAND.getKey()).getItem());
        Assertions.assertEquals(twoHanded, character
                .getItemSlot(DefaultItemSlots.OFF_HAND.getKey()).getItem());
    }

    @Test
    public final void testSlot_TwoHanded_Back_NotReplacesEquipment() {
        character.setStatValue(DefaultStats.STRENGTH.getKey(), 2);
        character.addToItemSlot(DefaultItemSlots.MAIN_HAND.getKey(),
                swordSmall);
        character.addToItemSlot(DefaultItemSlots.OFF_HAND.getKey(), swordBig);
        character.addToItemSlot(DefaultItemSlots.BACK.getKey(), twoHanded);

        Assertions.assertEquals(swordSmall, character
                .getItemSlot(DefaultItemSlots.MAIN_HAND.getKey()).getItem());
        Assertions.assertEquals(swordBig, character
                .getItemSlot(DefaultItemSlots.OFF_HAND.getKey()).getItem());
        Assertions.assertEquals(twoHanded, character
                .getItemSlot(DefaultItemSlots.BACK.getKey()).getItem());
    }

    @Test
    public final void testSlot_TwoHanded_ReplaceEquipment() {
        character.setStatValue(DefaultStats.STRENGTH.getKey(), 2);
        character.addToItemSlot(DefaultItemSlots.MAIN_HAND.getKey(),
                swordSmall);
        character.addToItemSlot(DefaultItemSlots.OFF_HAND.getKey(), swordBig);
        character.addToItemSlot(DefaultItemSlots.MAIN_HAND.getKey(), twoHanded);

        Assertions.assertEquals(twoHanded, character
                .getItemSlot(DefaultItemSlots.MAIN_HAND.getKey()).getItem());
        Assertions.assertEquals(twoHanded, character
                .getItemSlot(DefaultItemSlots.OFF_HAND.getKey()).getItem());
    }

}
