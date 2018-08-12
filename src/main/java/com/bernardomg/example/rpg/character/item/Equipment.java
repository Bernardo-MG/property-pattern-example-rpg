
package com.bernardomg.example.rpg.character.item;

import com.bernardomg.example.rpg.character.property.store.PropertyStore;
import com.bernardomg.example.rpg.character.stat.store.StatStore;

public interface Equipment extends Item, StatStore, PropertyStore {

    public Iterable<String> getSlots();

    public void setSlots(final Iterable<String> slots);

}
