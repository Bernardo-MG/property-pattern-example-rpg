
package com.bernardomg.example.rpg.character.item;

import com.bernardomg.example.rpg.character.stat.store.StatStore;
import com.bernardomg.example.rpg.property.store.PropertyStore;

public interface Equipment extends Item, StatStore, PropertyStore {

    public Iterable<String> getSlots();

    public void setSlots(final Iterable<String> slots);

}
