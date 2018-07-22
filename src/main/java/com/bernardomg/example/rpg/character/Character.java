
package com.bernardomg.example.rpg.character;

import com.bernardomg.example.rpg.character.item.Equipment;
import com.bernardomg.example.rpg.character.slot.item.ItemSlot;
import com.bernardomg.example.rpg.character.stat.store.StatStore;

public interface Character extends StatStore {

    public void addAbility(final Ability ability);

    public void addEquipment(final String slot, final Equipment item);

    public void addItemSlot(final ItemSlot slot);

    public Iterable<Ability> getAbilities();

    public Iterable<ItemSlot> getItemSlots();

    public void removeAbility(final Ability ability);

    public void removeEquipment(final String slot);

    public void removeItemSlot(final ItemSlot slot);

}
