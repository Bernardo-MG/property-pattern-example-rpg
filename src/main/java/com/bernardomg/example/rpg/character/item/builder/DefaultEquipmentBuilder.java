
package com.bernardomg.example.rpg.character.item.builder;

import java.util.Arrays;

import com.bernardomg.example.rpg.character.item.DefaultEquipment;
import com.bernardomg.example.rpg.character.item.Equipment;
import com.bernardomg.example.rpg.character.stat.DefaultValueStat;

public final class DefaultEquipmentBuilder implements EquipmentBuilder {

    private final Equipment equipment = new DefaultEquipment();

    public DefaultEquipmentBuilder() {
        super();
    }

    @Override
    public final Equipment get() {
        return equipment;
    }

    @Override
    public final EquipmentBuilder withAttribute(final String name,
            final Integer value) {

        equipment.setStat(name, new DefaultValueStat());
        equipment.setStatValue(name, value);

        return this;
    }

    @Override
    public final EquipmentBuilder withSlots(final Iterable<String> slots) {
        equipment.setSlots(slots);

        return this;
    }

    @Override
    public final EquipmentBuilder withSlots(final String slot) {
        equipment.setSlots(Arrays.asList(slot));

        return this;
    }

}
