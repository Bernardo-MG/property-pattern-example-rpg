
package com.bernardomg.example.rpg.constants;

public enum DefaultEvents {

    EQUIP_ITEM("equip_item");

    private final String key;

    private DefaultEvents(final String k) {
        key = k;
    }

    public String getKey() {
        return key;
    }

}
