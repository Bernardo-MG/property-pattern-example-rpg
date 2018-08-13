
package com.bernardomg.example.rpg.inventory.item;

import com.bernardomg.example.rpg.property.store.PropertyStore;
import com.bernardomg.example.rpg.stat.store.StatStore;

public interface Equipment extends Item, StatStore, PropertyStore {

    public Iterable<String> getSlots();

    public void setSlots(final Iterable<String> slots);

}
