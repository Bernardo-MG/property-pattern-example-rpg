
package com.bernardomg.example.rpg.builder.item;

public final class DefaultItemBuilder implements ItemBuilder {

    @Override
    public final EquipmentBuilder equipment() {
        return new DefaultEquipmentBuilder();
    }

}
