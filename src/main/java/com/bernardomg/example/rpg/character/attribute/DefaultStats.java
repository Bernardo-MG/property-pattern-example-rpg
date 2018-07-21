
package com.bernardomg.example.rpg.character.attribute;

public enum DefaultStats {

    DAMAGE("damage"),
    DEXTERITY("dexterity"),
    INTELLIGENCE("intelligence"),
    MANA("mana"),
    STRENGTH("strength");

    private final String key;

    private DefaultStats(final String k) {
        key = k;
    }

    public String getKey() {
        return key;
    }

}
