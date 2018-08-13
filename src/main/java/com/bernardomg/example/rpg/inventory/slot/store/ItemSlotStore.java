
package com.bernardomg.example.rpg.inventory.slot.store;

import com.bernardomg.example.rpg.inventory.item.Equipment;
import com.bernardomg.example.rpg.inventory.slot.ItemSlot;

public interface ItemSlotStore {

    public void addItemSlot(final ItemSlot slot);

    public Boolean addToItemSlot(final String slot, final Equipment item);

    public void clearSlot(final String slot);

    public ItemSlot getItemSlot(final String slot);

    public Iterable<ItemSlot> getItemSlots();

    public void removeItemSlot(final ItemSlot slot);

}
