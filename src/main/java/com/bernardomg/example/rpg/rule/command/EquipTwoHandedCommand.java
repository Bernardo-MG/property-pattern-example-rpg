
package com.bernardomg.example.rpg.rule.command;

import com.bernardomg.example.rpg.character.Character;
import com.bernardomg.example.rpg.character.event.equipment.EquipItemEvent;
import com.bernardomg.example.rpg.character.item.Equipment;
import com.bernardomg.example.rpg.character.slot.item.ItemSlot;
import com.bernardomg.example.rpg.command.Command;
import com.bernardomg.example.rpg.constants.DefaultItemSlots;

public final class EquipTwoHandedCommand implements Command<EquipItemEvent> {

    public EquipTwoHandedCommand() {
        super();
    }

    @Override
    public final void apply(final EquipItemEvent target) {
        // TODO: Don't receive an event
        final Character character;
        final Equipment equipment;

        character = target.getCharacter();
        equipment = target.getEquipment();

        character.addEquipment(DefaultItemSlots.MAIN_HAND.getKey(), equipment);
        character.addEquipment(DefaultItemSlots.OFF_HAND.getKey(), equipment);
    }

    @Override
    public final void undo(final EquipItemEvent target) {}

    @Override
    public final Boolean valid(final EquipItemEvent target) {
        final ItemSlot itemSlot;

        itemSlot = target.getItemSlot();

        return ((DefaultItemSlots.MAIN_HAND.getKey().equals(itemSlot.getName()))
                || (DefaultItemSlots.OFF_HAND.getKey()
                        .equals(itemSlot.getName())));
    }

}
