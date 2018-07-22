
package com.bernardomg.example.rpg.character.slot.item;

import com.bernardomg.example.rpg.character.item.Equipment;

public final class DefaultItemSlot implements ItemSlot {

    private Equipment    item;

    private final String name;

    public DefaultItemSlot(final String slotName) {
        super();

        name = slotName;
    }

    @Override
    public final Equipment getItem() {
        return item;
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final void setItem(final Equipment item) {
        this.item = item;
    }

}
