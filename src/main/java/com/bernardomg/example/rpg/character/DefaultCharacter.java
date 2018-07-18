
package com.bernardomg.example.rpg.character;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DefaultCharacter implements Character {

    private final Collection<Ability> abilities         = new ArrayList<>();

    private Integer                   agility           = 0;

    private final DerivedAttributes   derivedAttributes = new DerivedAttributesCalculator(
            this);

    private Integer                   intelligence      = 0;

    private Integer                   strength          = 0;

    public DefaultCharacter() {
        super();
    }

    @Override
    public void addAbility(final Ability ability) {
        abilities.add(ability);
    }

    @Override
    public Iterable<Ability> getAbilities() {
        return Collections.unmodifiableCollection(abilities);
    }

    @Override
    public Integer getAgility() {
        return agility;
    }

    @Override
    public Integer getDamage() {
        return getDerivedAttributes().getDamage();
    }

    @Override
    public Integer getIntelligence() {
        return intelligence;
    }

    @Override
    public Integer getMana() {
        return getDerivedAttributes().getMana();
    }

    @Override
    public Integer getStrength() {
        return strength;
    }

    @Override
    public void removeAbility(final Ability ability) {
        abilities.remove(ability);
    }

    @Override
    public void setAgility(final Integer value) {
        agility = value;
    }

    @Override
    public void setIntelligence(final Integer value) {
        intelligence = value;
    }

    @Override
    public void setStrength(final Integer value) {
        strength = value;
    }

    private DerivedAttributes getDerivedAttributes() {
        return derivedAttributes;
    }

}
