
package com.bernardomg.example.rpg.character;

public class DerivedAttributesCalculator implements DerivedAttributes {

    private final Attributes attributes;

    public DerivedAttributesCalculator(final Attributes attrs) {
        super();

        attributes = attrs;
    }

    @Override
    public Integer getDamage() {
        return getAttributes().getStrength() * 2;
    }

    @Override
    public Integer getMana() {
        return getAttributes().getIntelligence();
    }

    private Attributes getAttributes() {
        return attributes;
    }

}
