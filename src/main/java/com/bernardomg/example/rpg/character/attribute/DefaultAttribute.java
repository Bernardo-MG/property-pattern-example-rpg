
package com.bernardomg.example.rpg.character.attribute;

public final class DefaultAttribute implements Attribute {

    private Integer value;

    public DefaultAttribute() {
        super();
    }

    @Override
    public final Integer getValue() {
        return value;
    }

    @Override
    public final void setValue(final Integer value) {
        this.value = value;
    }

}
