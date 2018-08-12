
package com.bernardomg.example.rpg.character.unit.item;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.example.rpg.character.Character;
import com.bernardomg.example.rpg.character.builder.DefaultCharacterBuilder;
import com.bernardomg.example.rpg.character.item.Equipment;
import com.bernardomg.example.rpg.character.item.builder.DefaultItemBuilder;
import com.bernardomg.example.rpg.constants.DefaultItemSlots;
import com.bernardomg.example.rpg.constants.DefaultProperties;
import com.bernardomg.example.rpg.constants.DefaultStats;
import com.bernardomg.example.rpg.rule.command.EquipTwoHandedCommand;

@RunWith(JUnitPlatform.class)
public final class TestDefaultCharacterItemSlot {

    private final Character character;

    private final Equipment swordBig;

    private final Equipment swordSmall;

    private final Equipment twoHanded;

    public TestDefaultCharacterItemSlot() {
        super();

        character = new DefaultCharacterBuilder()
                .withAttribute(DefaultStats.STRENGTH.getKey())
                .withMultipliedDerivedAttribute(DefaultStats.DAMAGE.getKey(),
                        DefaultStats.STRENGTH.getKey(), 2)
                .withItemSlot(DefaultItemSlots.MAIN_HAND.getKey())
                .withItemSlot(DefaultItemSlots.OFF_HAND.getKey())
                .withItemSlot(DefaultItemSlots.BACK.getKey())
                .registerProperty(DefaultProperties.TWO_HANDED.getKey(),
                        new EquipTwoHandedCommand())
                .get();

        swordSmall = new DefaultItemBuilder().equipment()
                .withSlots(Arrays.asList(DefaultItemSlots.MAIN_HAND.getKey(),
                        DefaultItemSlots.OFF_HAND.getKey()))
                .withAttribute(DefaultStats.DAMAGE.getKey(), 5).get();
        swordBig = new DefaultItemBuilder().equipment()
                .withSlots(Arrays.asList(DefaultItemSlots.MAIN_HAND.getKey(),
                        DefaultItemSlots.OFF_HAND.getKey()))
                .withAttribute(DefaultStats.DAMAGE.getKey(), 10).get();
        twoHanded = new DefaultItemBuilder().equipment()
                .withSlots(Arrays.asList(DefaultItemSlots.MAIN_HAND.getKey(),
                        DefaultItemSlots.OFF_HAND.getKey(),
                        DefaultItemSlots.BACK.getKey()))
                .withAttribute(DefaultStats.DAMAGE.getKey(), 10)
                .withProperty(DefaultProperties.TWO_HANDED.getKey()).get();
    }

    @Test
    public final void testSlot_BothHands() {
        character.addEquipment(DefaultItemSlots.MAIN_HAND.getKey(), swordSmall);
        character.addEquipment(DefaultItemSlots.OFF_HAND.getKey(), swordBig);

        Assertions.assertEquals(swordSmall,
                character.getEquipment(DefaultItemSlots.MAIN_HAND.getKey()));
        Assertions.assertEquals(swordBig,
                character.getEquipment(DefaultItemSlots.OFF_HAND.getKey()));
    }

    @Test
    public final void testSlot_InvalidSlot() {
        character.addEquipment(DefaultItemSlots.ARMOR.getKey(), swordSmall);

        Assertions.assertNull(
                character.getEquipment(DefaultItemSlots.ARMOR.getKey()));
    }

    @Test
    public final void testSlot_ReplaceEquipment() {
        character.addEquipment(DefaultItemSlots.MAIN_HAND.getKey(), swordSmall);
        character.addEquipment(DefaultItemSlots.MAIN_HAND.getKey(), swordBig);

        Assertions.assertEquals(swordBig,
                character.getEquipment(DefaultItemSlots.MAIN_HAND.getKey()));
    }

    @Test
    public final void testSlot_TwoHanded() {
        character.addEquipment(DefaultItemSlots.MAIN_HAND.getKey(), twoHanded);

        Assertions.assertEquals(twoHanded,
                character.getEquipment(DefaultItemSlots.MAIN_HAND.getKey()));
        Assertions.assertEquals(twoHanded,
                character.getEquipment(DefaultItemSlots.OFF_HAND.getKey()));
    }

    @Test
    public final void testSlot_TwoHanded_Back_NotReplacesEquipment() {
        character.setStatValue(DefaultStats.STRENGTH.getKey(), 2);
        character.addEquipment(DefaultItemSlots.MAIN_HAND.getKey(), swordSmall);
        character.addEquipment(DefaultItemSlots.OFF_HAND.getKey(), swordBig);
        character.addEquipment(DefaultItemSlots.BACK.getKey(), twoHanded);

        Assertions.assertEquals(swordSmall,
                character.getEquipment(DefaultItemSlots.MAIN_HAND.getKey()));
        Assertions.assertEquals(swordBig,
                character.getEquipment(DefaultItemSlots.OFF_HAND.getKey()));
        Assertions.assertEquals(twoHanded,
                character.getEquipment(DefaultItemSlots.BACK.getKey()));
    }

    @Test
    public final void testSlot_TwoHanded_ReplaceEquipment() {
        character.setStatValue(DefaultStats.STRENGTH.getKey(), 2);
        character.addEquipment(DefaultItemSlots.MAIN_HAND.getKey(), swordSmall);
        character.addEquipment(DefaultItemSlots.OFF_HAND.getKey(), swordBig);
        character.addEquipment(DefaultItemSlots.MAIN_HAND.getKey(), twoHanded);

        Assertions.assertEquals(twoHanded,
                character.getEquipment(DefaultItemSlots.MAIN_HAND.getKey()));
        Assertions.assertEquals(twoHanded,
                character.getEquipment(DefaultItemSlots.OFF_HAND.getKey()));
    }

}
