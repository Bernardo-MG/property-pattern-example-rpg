
package com.bernardomg.example.rpg.character;

public interface Character {

    public void addAbility(final Ability ability);

    public Iterable<Ability> getAbilities();

    public Integer getAttribute(final String attribute);

    public Boolean hasAttribute(final String attribute);

    public void removeAbility(final Ability ability);

    public void setAttribute(final String attribute, final Integer value);

}
