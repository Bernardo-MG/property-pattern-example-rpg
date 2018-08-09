
package com.bernardomg.example.rpg.character.item;

import com.bernardomg.example.rpg.character.stat.store.StatStore;

public interface Equipment extends Item, StatStore {

    public Iterable<String> getSlots();
    
    public void setSlots(final Iterable<String> slots);

}
