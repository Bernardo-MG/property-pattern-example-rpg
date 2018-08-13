
package com.bernardomg.example.rpg.inventory.slot;

import com.bernardomg.example.rpg.character.Character;
import com.bernardomg.example.rpg.inventory.item.Equipment;

public final class WrapperCharacterItemSlot implements CharacterItemSlot {

    private final Character character;

    private final ItemSlot  itemSlot;

    public WrapperCharacterItemSlot(final Character character,
            final ItemSlot itemSlot) {
        super();

        this.character = character;
        this.itemSlot = itemSlot;
    }

    @Override
    public final Character getCharacter() {
        return character;
    }

    @Override
    public final Equipment getItem() {
        return itemSlot.getItem();
    }

    @Override
    public final String getName() {
        // TODO Auto-generated method stub
        return itemSlot.getName();
    }

    @Override
    public final void setItem(final Equipment item) {
        itemSlot.setItem(item);
    }

}
