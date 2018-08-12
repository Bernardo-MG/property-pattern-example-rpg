
package com.bernardomg.example.rpg.constants;

public enum DefaultAbilities {

    MAGIC_DAMAGE("magic_damage"), PLACEHOLDER("placeholder");

    private final String key;

    private DefaultAbilities(final String k) {
        key = k;
    }

    public String getKey() {
        return key;
    }

}
