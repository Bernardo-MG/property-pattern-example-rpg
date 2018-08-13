
package com.bernardomg.example.rpg.character;

import com.bernardomg.example.rpg.ability.Ability;
import com.bernardomg.example.rpg.inventory.item.store.ItemStore;
import com.bernardomg.example.rpg.inventory.slot.store.ItemSlotStore;
import com.bernardomg.example.rpg.stat.store.StatStore;

public interface Character extends StatStore, ItemStore, ItemSlotStore {

    public void addAbility(final Ability ability);

    public Iterable<Ability> getAbilities();

    public void removeAbility(final Ability ability);

}
