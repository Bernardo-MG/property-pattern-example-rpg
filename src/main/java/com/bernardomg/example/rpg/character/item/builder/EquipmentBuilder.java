
package com.bernardomg.example.rpg.character.item.builder;

import com.bernardomg.example.rpg.character.item.Equipment;

public interface EquipmentBuilder {

    public Equipment get();

    public EquipmentBuilder withAttribute(final String name,
            final Integer value);

}
