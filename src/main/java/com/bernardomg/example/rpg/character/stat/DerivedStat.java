
package com.bernardomg.example.rpg.character.stat;

public interface DerivedStat extends Stat {

    public String getStat();

    public Integer getValue(final Stat stat);

}
