
package com.bernardomg.example.rpg.character.event.equipment;

import com.bernardomg.example.rpg.character.Character;
import com.bernardomg.example.rpg.event.Event;
import com.bernardomg.example.rpg.inventory.item.Equipment;
import com.bernardomg.example.rpg.inventory.slot.ItemSlot;

public final class EquipItemEvent implements Event {

    private final Character character;

    private final Equipment equipment;

    private final ItemSlot  itemSlot;

    public EquipItemEvent(final Character character, final Equipment equipment,
            final ItemSlot itemSlot) {
        super();

        this.equipment = equipment;
        this.character = character;
        this.itemSlot = itemSlot;
    }

    public final Character getCharacter() {
        return character;
    }

    public final Equipment getEquipment() {
        return equipment;
    }

    public final ItemSlot getItemSlot() {
        return itemSlot;
    }

}
