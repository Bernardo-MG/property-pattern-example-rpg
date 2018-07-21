
package com.bernardomg.example.rpg.character;

import com.bernardomg.example.rpg.character.attribute.Stat;

public interface Character {

    public void addAbility(final Ability ability);

    public Iterable<Ability> getAbilities();

    public Integer getStatValue(final String attribute);

    public Boolean hasStat(final String attribute);

    public void removeAbility(final Ability ability);

    public void setStat(final String name, final Stat value);

    public void setStatValue(final String attribute, final Integer value);

}
