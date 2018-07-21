
package com.bernardomg.example.rpg.character;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.bernardomg.example.rpg.character.attribute.DefaultStats;
import com.bernardomg.example.rpg.character.attribute.DefaultValueStat;
import com.bernardomg.example.rpg.character.attribute.DerivedStat;
import com.bernardomg.example.rpg.character.attribute.MultipliedDerivedStat;
import com.bernardomg.example.rpg.character.attribute.Stat;
import com.bernardomg.example.rpg.character.attribute.ValueStat;

public final class DefaultCharacter implements Character {

    private final Collection<Ability> abilities  = new ArrayList<>();

    private final Map<String, Stat>   attributes = new HashMap<>();

    public DefaultCharacter() {
        super();

        attributes.put(DefaultStats.DEXTERITY.getKey(), new DefaultValueStat());
        attributes.put(DefaultStats.INTELLIGENCE.getKey(),
                new DefaultValueStat());
        attributes.put(DefaultStats.STRENGTH.getKey(), new DefaultValueStat());

        attributes.put(DefaultStats.DAMAGE.getKey(),
                new MultipliedDerivedStat(DefaultStats.STRENGTH.getKey(), 2));
        attributes.put(DefaultStats.MANA.getKey(), new MultipliedDerivedStat(
                DefaultStats.INTELLIGENCE.getKey(), 1));
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
        final Stat stat;
        final Stat mainStat;
        final DerivedStat derived;
        final Integer value;

        stat = attributes.get(attribute);

        if (stat instanceof ValueStat) {
            value = ((ValueStat) stat).getValue();
        } else if (stat instanceof DerivedStat) {
            derived = ((DerivedStat) stat);
            if (attributes.containsKey(derived.getAttribute())) {
                mainStat = attributes.get(derived.getAttribute());
                value = ((DerivedStat) stat).getValue(mainStat);
            } else {
                value = 0;
            }
        } else {
            value = 0;
        }

        return value;
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
        final Stat stat;

        stat = attributes.get(attribute);

        if (stat instanceof ValueStat) {
            ((ValueStat) stat).setValue(value);
        }
    }

}
