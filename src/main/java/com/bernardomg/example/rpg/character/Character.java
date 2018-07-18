
package com.bernardomg.example.rpg.character;

public interface Character extends Attributes, DerivedAttributes {

    public void addAbility(final Ability ability);

    public Iterable<Ability> getAbilities();

    public void removeAbility(final Ability ability);

    public void setAgility(final Integer value);

    public void setIntelligence(final Integer value);

    public void setStrength(final Integer value);

}
