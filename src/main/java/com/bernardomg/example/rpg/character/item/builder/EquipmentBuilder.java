
package com.bernardomg.example.rpg.character.item.builder;

import com.bernardomg.example.rpg.character.item.Equipment;

public interface EquipmentBuilder {

    public Equipment get();

    public EquipmentBuilder withAttribute(final String name,
            final Integer value);

    public EquipmentBuilder withSlots(final Iterable<String> slots);

    public EquipmentBuilder withSlots(final String slot);

}
