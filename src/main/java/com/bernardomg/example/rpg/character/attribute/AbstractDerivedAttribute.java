
package com.bernardomg.example.rpg.character.attribute;

public abstract class AbstractDerivedAttribute implements Attribute {

    private final Attribute attribute;

    public AbstractDerivedAttribute(final Attribute att) {
        super();

        attribute = att;
    }

    protected final Attribute getWrappedAttribute() {
        return attribute;
    }

}
