
package com.bernardomg.example.rpg.character.constants;

public enum DefaultItemSlots {

    LEFT_HAND("damage");

    private final String key;

    private DefaultItemSlots(final String k) {
        key = k;
    }

    public String getKey() {
        return key;
    }

}
