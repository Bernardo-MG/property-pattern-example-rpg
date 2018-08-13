
package com.bernardomg.example.rpg.stat;

public interface DerivedStat extends Stat {

    public String getStat();

    /**
     * TODO: What happens if it depends on several stats?
     * 
     * @param stat
     * @return
     */
    public Integer getValue(final Stat stat);

}
