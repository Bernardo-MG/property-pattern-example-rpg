
package com.bernardomg.example.rpg.character;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.bernardomg.example.rpg.character.attribute.Attribute;
import com.bernardomg.example.rpg.character.attribute.DefaultAttribute;
import com.bernardomg.example.rpg.character.attribute.MultipliedDerivedAttribute;

public final class DefaultCharacter implements Character {

    private final Collection<Ability>    abilities  = new ArrayList<>();

    private final Map<String, Attribute> attributes = new HashMap<>();

    public DefaultCharacter() {
        super();

        attributes.put("agility", new DefaultAttribute());
        attributes.put("intelligence", new DefaultAttribute());
        attributes.put("strength", new DefaultAttribute());

        attributes.put("damage",
                new MultipliedDerivedAttribute(attributes.get("strength"), 2));
        attributes.put("mana", new MultipliedDerivedAttribute(
                attributes.get("intelligence"), 1));
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
    public final Integer getAttribute(final String attribute) {
        return attributes.get(attribute).getValue();
    }

    @Override
    public final Boolean hasAttribute(final String attribute) {
        return attributes.containsKey(attribute);
    }

    @Override
    public final void removeAbility(final Ability ability) {
        abilities.remove(ability);
    }

    @Override
    public final void setAttribute(final String attribute,
            final Integer value) {
        attributes.get(attribute).setValue(value);
    }

}
