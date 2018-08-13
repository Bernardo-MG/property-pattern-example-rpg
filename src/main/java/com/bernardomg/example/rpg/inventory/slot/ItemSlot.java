
package com.bernardomg.example.rpg.inventory.slot;

import com.bernardomg.example.rpg.inventory.item.Equipment;

public interface ItemSlot {

    public Equipment getItem();

    public String getName();

    public void setItem(final Equipment item);

}
