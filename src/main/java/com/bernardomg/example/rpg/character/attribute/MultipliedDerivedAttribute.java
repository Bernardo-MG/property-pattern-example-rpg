
package com.bernardomg.example.rpg.character.attribute;

public final class MultipliedDerivedAttribute extends AbstractDerivedAttribute {

    private final Integer multiple;

    public MultipliedDerivedAttribute(final Attribute att, final Integer mult) {
        super(att);

        multiple = mult;
    }

    public final Integer getMultiple() {
        return multiple;
    }

    @Override
    public final Integer getValue() {
        return getWrappedAttribute().getValue() * getMultiple();
    }

    @Override
    public final void setValue(final Integer value) {

    }

}
