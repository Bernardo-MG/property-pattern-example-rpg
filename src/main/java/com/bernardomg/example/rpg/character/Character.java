
package com.bernardomg.example.rpg.character;

public interface Character {

    public void addAbility(final Ability ability);

    public Iterable<Ability> getAbilities();

    public Integer getAgility();

    public Integer getDamage();

    public Integer getIntelligence();

    public Integer getMana();

    public Integer getStrength();

    public void removeAbility(final Ability ability);

    public void setAgility(final Integer value);

    public void setIntelligence(final Integer value);

    public void setStrength(final Integer value);

}
