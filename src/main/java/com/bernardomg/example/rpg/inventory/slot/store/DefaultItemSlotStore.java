
package com.bernardomg.example.rpg.inventory.slot.store;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.StreamSupport;

import com.bernardomg.example.rpg.inventory.item.EmptyEquipment;
import com.bernardomg.example.rpg.inventory.item.Equipment;
import com.bernardomg.example.rpg.inventory.slot.ItemSlot;

public final class DefaultItemSlotStore implements ItemSlotStore {

    private final Collection<ItemSlot> equipment = new ArrayList<>();

    public DefaultItemSlotStore() {
        super();
    }

    @Override
    public final void addItemSlot(final ItemSlot slot) {
        equipment.add(slot);
    }

    @Override
    public final Boolean addToItemSlot(final String slot,
            final Equipment item) {
        final Optional<ItemSlot> foundSlot;
        final ItemSlot itemSlot;
        final Boolean validSlot;
        final Boolean added;

        validSlot = StreamSupport.stream(item.getSlots().spliterator(), false)
                .filter((s) -> s.equals(slot)).findAny().isPresent();

        if (validSlot) {
            foundSlot = equipment.stream()
                    .filter((s) -> s.getName().equals(slot)).findFirst();

            if (foundSlot.isPresent()) {
                itemSlot = foundSlot.get();
                itemSlot.setItem(item);

                added = true;
            } else {
                added = false;
            }
        } else {
            added = false;
        }

        return added;
    }

    @Override
    public final void clearSlot(final String slot) {
        final Optional<ItemSlot> foundSlot;
        final ItemSlot itemSlot;

        foundSlot = equipment.stream().filter((s) -> s.getName().equals(slot))
                .findFirst();
        if (foundSlot.isPresent()) {
            itemSlot = foundSlot.get();
            itemSlot.setItem(new EmptyEquipment());
        }
    }

    @Override
    public final ItemSlot getItemSlot(final String slot) {
        final Optional<ItemSlot> foundSlot;
        final ItemSlot itemSlot;

        foundSlot = equipment.stream().filter((s) -> s.getName().equals(slot))
                .findFirst();

        if (foundSlot.isPresent()) {
            itemSlot = foundSlot.get();
        } else {
            itemSlot = null;
        }

        return itemSlot;
    }

    @Override
    public final Iterable<ItemSlot> getItemSlots() {
        return Collections.unmodifiableCollection(equipment);
    }

    @Override
    public final void removeItemSlot(final ItemSlot slot) {
        equipment.remove(slot);
    }

}
