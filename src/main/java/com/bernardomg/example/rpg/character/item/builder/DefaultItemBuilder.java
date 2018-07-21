
package com.bernardomg.example.rpg.character.item.builder;

public final class DefaultItemBuilder implements ItemBuilder {

    @Override
    public final EquipmentBuilder equipment() {
        return new DefaultEquipmentBuilder();
    }

}
