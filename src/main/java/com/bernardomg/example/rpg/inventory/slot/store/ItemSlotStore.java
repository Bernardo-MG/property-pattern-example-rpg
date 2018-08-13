
package com.bernardomg.example.rpg.inventory.slot.store;

import com.bernardomg.example.rpg.inventory.slot.ItemSlot;

public interface ItemSlotStore {

    public void addItemSlot(final ItemSlot slot);

    public ItemSlot getItemSlot(final String slot);

    public Iterable<ItemSlot> getItemSlots();

    public void removeItemSlot(final ItemSlot slot);

}
