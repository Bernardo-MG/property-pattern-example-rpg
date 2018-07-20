
package com.bernardomg.example.rpg.character;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.bernardomg.example.rpg.character.attribute.Attribute;
import com.bernardomg.example.rpg.character.attribute.DefaultAttribute;
import com.bernardomg.example.rpg.character.attribute.MultipliedDerivedAttribute;

public final class DefaultCharacter implements Character {

    private final Collection<Ability> abilities    = new ArrayList<>();

    private final Attribute           agility      = new DefaultAttribute();

    private final Attribute           damage;

    private final Attribute           intelligence = new DefaultAttribute();

    private final Attribute           mana;

    private final Attribute           strength     = new DefaultAttribute();

    public DefaultCharacter() {
        super();

        damage = new MultipliedDerivedAttribute(strength, 2);
        mana = new MultipliedDerivedAttribute(intelligence, 1);
    }

    @Override
    public final void addAbility(final Ability ability) {
        abilities.add(ability);
    }

    @Override
    public final Iterable<Ability> getAbilities() {
        return Collections.unmodifiableCollection(abilities);
    }

    @Override
    public final Integer getAgility() {
        return agility.getValue();
    }

    @Override
    public final Integer getDamage() {
        return damage.getValue();
    }

    @Override
    public final Integer getIntelligence() {
        return intelligence.getValue();
    }

    @Override
    public final Integer getMana() {
        return mana.getValue();
    }

    @Override
    public final Integer getStrength() {
        return strength.getValue();
    }

    @Override
    public final void removeAbility(final Ability ability) {
        abilities.remove(ability);
    }

    @Override
    public final void setAgility(final Integer value) {
        agility.setValue(value);
    }

    @Override
    public final void setIntelligence(final Integer value) {
        intelligence.setValue(value);
    }

    @Override
    public final void setStrength(final Integer value) {
        strength.setValue(value);
    }

}
