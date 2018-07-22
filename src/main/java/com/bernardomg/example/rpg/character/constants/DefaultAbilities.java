
package com.bernardomg.example.rpg.character.constants;

public enum DefaultAbilities {

    MAGIC_DAMAGE("magic_damage");

    private final String key;

    private DefaultAbilities(final String k) {
        key = k;
    }

    public String getKey() {
        return key;
    }

}
