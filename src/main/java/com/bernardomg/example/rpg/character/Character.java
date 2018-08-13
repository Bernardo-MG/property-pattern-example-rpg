
package com.bernardomg.example.rpg.character;

import com.bernardomg.example.rpg.ability.Ability;
import com.bernardomg.example.rpg.inventory.item.Equipment;
import com.bernardomg.example.rpg.inventory.slot.ItemSlot;
import com.bernardomg.example.rpg.stat.store.StatStore;

public interface Character extends StatStore {

    public void addAbility(final Ability ability);

    public void addEquipment(final String slot, final Equipment item);

    public void addItemSlot(final ItemSlot slot);

    public Iterable<Ability> getAbilities();

    public Equipment getEquipment(final String slot);

    public Iterable<ItemSlot> getItemSlots();

    public void removeAbility(final Ability ability);

    public void removeEquipment(final String slot);

    public void removeItemSlot(final ItemSlot slot);

}
