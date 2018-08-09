
package com.bernardomg.example.rpg.character.constants;

public enum DefaultItemSlots {

    MAIN_HAND("main_hand"), OFF_HAND("off_hand"), ARMOR("armor");

    private final String key;

    private DefaultItemSlots(final String k) {
        key = k;
    }

    public String getKey() {
        return key;
    }

}
