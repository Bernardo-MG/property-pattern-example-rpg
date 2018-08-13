
package com.bernardomg.example.rpg.rule.command;

import com.bernardomg.example.rpg.character.Character;
import com.bernardomg.example.rpg.command.Command;
import com.bernardomg.example.rpg.constants.DefaultItemSlots;
import com.bernardomg.example.rpg.inventory.item.Equipment;
import com.bernardomg.example.rpg.inventory.slot.CharacterItemSlot;
import com.bernardomg.example.rpg.inventory.slot.ItemSlot;

public final class EquipTwoHandedCommand implements Command {

    public EquipTwoHandedCommand() {
        super();
    }

    @Override
    public final void apply(final Object target) {
        // TODO: Don't receive an event
        final Character character;
        final Equipment equipment;
        final CharacterItemSlot event;

        event = (CharacterItemSlot) target;

        character = event.getCharacter();
        equipment = event.getItem();

        character.addToItemSlot(DefaultItemSlots.MAIN_HAND.getKey(), equipment);
        character.addToItemSlot(DefaultItemSlots.OFF_HAND.getKey(), equipment);
    }

    @Override
    public final void undo(final Object target) {}

    @Override
    public final Boolean valid(final Object target) {
        final ItemSlot itemSlot;
        final Boolean valid;

        if (target instanceof CharacterItemSlot) {
            itemSlot = ((ItemSlot) target);

            valid = ((DefaultItemSlots.MAIN_HAND.getKey()
                    .equals(itemSlot.getName()))
                    || (DefaultItemSlots.OFF_HAND.getKey()
                            .equals(itemSlot.getName())));
        } else {
            valid = false;
        }

        return valid;
    }

}
