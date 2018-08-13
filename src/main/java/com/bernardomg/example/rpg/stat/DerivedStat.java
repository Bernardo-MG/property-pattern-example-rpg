
package com.bernardomg.example.rpg.stat;

public interface DerivedStat extends Stat {

    public String getStat();

    public Integer getValue(final Stat stat);

}
