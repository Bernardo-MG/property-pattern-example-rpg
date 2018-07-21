
package com.bernardomg.example.rpg.character.attribute;

public interface DerivedStat extends Stat {

    public String getAttribute();

    public Integer getValue(final Stat stat);

}
