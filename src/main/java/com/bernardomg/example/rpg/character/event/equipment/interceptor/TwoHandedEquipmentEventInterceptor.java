
package com.bernardomg.example.rpg.character.event.equipment.interceptor;

import com.bernardomg.example.rpg.character.event.equipment.EquipItemEvent;
import com.bernardomg.example.rpg.character.item.Equipment;
import com.bernardomg.example.rpg.character.slot.item.ItemSlot;
import com.bernardomg.example.rpg.constants.DefaultItemSlots;
import com.bernardomg.example.rpg.constants.DefaultProperties;
import com.bernardomg.example.rpg.event.Event;
import com.bernardomg.example.rpg.event.EventInterceptor;
import com.bernardomg.example.rpg.rule.command.EquipTwoHandedCommand;

public final class TwoHandedEquipmentEventInterceptor
        implements EventInterceptor {

    public TwoHandedEquipmentEventInterceptor() {
        super();
    }

    @Override
    public final Boolean accepts(final Event event) {
        final Boolean result;

        if (event instanceof EquipItemEvent) {
            result = accepts((EquipItemEvent) event);
        } else {
            result = false;
        }

        return result;
    }

    @Override
    public final void onEvent(final Event event) {
        new EquipTwoHandedCommand().apply((EquipItemEvent) event);
    }

    private final Boolean accepts(final EquipItemEvent event) {
        final Equipment equipment;
        final ItemSlot slot;
        final Boolean toHand;
        final Boolean twoHanded;

        equipment = event.getEquipment();
        slot = event.getItemSlot();
        toHand = ((DefaultItemSlots.MAIN_HAND.getKey().equals(slot.getName()))
                || (DefaultItemSlots.OFF_HAND.getKey().equals(slot.getName())));
        twoHanded = equipment
                .hasProperty(DefaultProperties.TWO_HANDED.getKey());

        return toHand && twoHanded;
    }

}
