
package com.bernardomg.example.rpg.constants;

public enum DefaultItemSlots {

    ARMOR("armor"), BACK("back"), MAIN_HAND("main_hand"), OFF_HAND("off_hand");

    private final String key;

    private DefaultItemSlots(final String k) {
        key = k;
    }

    public String getKey() {
        return key;
    }

}
