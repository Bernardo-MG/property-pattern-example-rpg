
package com.bernardomg.example.rpg.constants;

public enum DefaultProperties {

    TWO_HANDED("two_handed");

    private final String key;

    private DefaultProperties(final String k) {
        key = k;
    }

    public String getKey() {
        return key;
    }

}
