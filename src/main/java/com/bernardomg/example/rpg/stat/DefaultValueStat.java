
package com.bernardomg.example.rpg.stat;

public final class DefaultValueStat implements ValueStat {

    private Integer value;

    public DefaultValueStat() {
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
