
package com.bernardomg.example.rpg.character.unit.factory;

import java.util.Arrays;

import com.bernardomg.example.rpg.builder.item.DefaultItemBuilder;
import com.bernardomg.example.rpg.constants.DefaultItemSlots;
import com.bernardomg.example.rpg.constants.DefaultProperties;
import com.bernardomg.example.rpg.constants.DefaultStats;
import com.bernardomg.example.rpg.inventory.item.Equipment;

public final class TestItemFactory {

    public static final Equipment getBigSword() {
        return new DefaultItemBuilder().equipment()
                .withSlots(Arrays.asList(DefaultItemSlots.MAIN_HAND.getKey(),
                        DefaultItemSlots.OFF_HAND.getKey()))
                .withAttribute(DefaultStats.DAMAGE.getKey(), 10).get();
    }

    public static final Equipment getSmallSword() {
        return new DefaultItemBuilder().equipment()
                .withSlots(Arrays.asList(DefaultItemSlots.MAIN_HAND.getKey(),
                        DefaultItemSlots.OFF_HAND.getKey()))
                .withAttribute(DefaultStats.DAMAGE.getKey(), 5).get();
    }

    public static final Equipment getTwoHandedSword() {
        return new DefaultItemBuilder().equipment()
                .withSlots(Arrays.asList(DefaultItemSlots.MAIN_HAND.getKey(),
                        DefaultItemSlots.OFF_HAND.getKey(),
                        DefaultItemSlots.BACK.getKey()))
                .withAttribute(DefaultStats.DAMAGE.getKey(), 10)
                .withProperty(DefaultProperties.TWO_HANDED.getKey()).get();
    }

    private TestItemFactory() {
        super();
    }

}
