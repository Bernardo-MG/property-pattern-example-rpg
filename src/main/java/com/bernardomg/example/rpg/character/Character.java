
package com.bernardomg.example.rpg.character;

import com.bernardomg.example.rpg.character.attribute.Stat;

public interface Character {

    public void addAbility(final Ability ability);

    public void addStat(final String name, final Stat value);

    public Iterable<Ability> getAbilities();

    public Integer getStat(final String attribute);

    public Boolean hasStat(final String attribute);

    public void removeAbility(final Ability ability);

    public void setStat(final String attribute, final Integer value);

}
