
package com.bernardomg.example.rpg.inventory.item.store;

import com.bernardomg.example.rpg.inventory.item.Equipment;

public interface ItemStore {

    public Boolean addEquipment(final String slot, final Equipment item);

    public Equipment getEquipment(final String slot);

    public void removeEquipment(final String slot);

}
