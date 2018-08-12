
package com.bernardomg.example.rpg.character.event.equipment.interceptor;

import com.bernardomg.example.rpg.character.Character;
import com.bernardomg.example.rpg.character.constants.DefaultItemSlots;
import com.bernardomg.example.rpg.character.constants.DefaultProperties;
import com.bernardomg.example.rpg.character.event.equipment.EquipItemEvent;
import com.bernardomg.example.rpg.character.item.EmptyEquipment;
import com.bernardomg.example.rpg.character.item.Equipment;
import com.bernardomg.example.rpg.character.slot.item.ItemSlot;
import com.bernardomg.example.rpg.event.EventInterceptor;

public final class TwoHandedEquipmentEventInterceptor
        implements EventInterceptor<EquipItemEvent> {

    public TwoHandedEquipmentEventInterceptor() {
        super();
    }

    @Override
    public final Boolean accepts(final EquipItemEvent event) {
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

    @Override
    public final void onEvent(final EquipItemEvent event) {
        final Character character;
        final Equipment equipment;

        character = event.getCharacter();
        equipment = event.getEquipment();

        character.addEquipment(DefaultItemSlots.MAIN_HAND.getKey(),
                new EmptyEquipment());
        character.addEquipment(DefaultItemSlots.OFF_HAND.getKey(),
                new EmptyEquipment());

        character.addEquipment(DefaultItemSlots.MAIN_HAND.getKey(), equipment);
    }

}