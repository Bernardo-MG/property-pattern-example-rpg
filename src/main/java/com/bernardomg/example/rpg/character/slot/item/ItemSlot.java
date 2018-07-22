
package com.bernardomg.example.rpg.character.slot.item;

import com.bernardomg.example.rpg.character.item.Equipment;

public interface ItemSlot {

    public Equipment getItem();

    public String getName();

    public void setItem(final Equipment item);

}
