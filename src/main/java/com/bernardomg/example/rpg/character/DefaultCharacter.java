
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

    private final Collection<Ability> abilities = new ArrayList<>();

    private final Map<String, Stat>   stats     = new HashMap<>();

    public DefaultCharacter() {
        super();

        stats.put(DefaultStats.DEXTERITY.getKey(), new DefaultValueStat());
        stats.put(DefaultStats.INTELLIGENCE.getKey(), new DefaultValueStat());
        stats.put(DefaultStats.STRENGTH.getKey(), new DefaultValueStat());

        stats.put(DefaultStats.DAMAGE.getKey(),
                new MultipliedDerivedStat(DefaultStats.STRENGTH.getKey(), 2));
        stats.put(DefaultStats.MANA.getKey(), new MultipliedDerivedStat(
                DefaultStats.INTELLIGENCE.getKey(), 1));
    }

    @Override
    public final void addAbility(final Ability ability) {
        abilities.add(ability);
    }

    @Override
    public final void addStat(final String name, final Stat value) {
        stats.put(name, value);
    }

    @Override
    public final Iterable<Ability> getAbilities() {
        return Collections.unmodifiableCollection(abilities);
    }

    @Override
    public final Integer getStat(final String attribute) {
        final Stat stat;
        final Stat mainStat;
        final DerivedStat derived;
        final Integer value;

        stat = stats.get(attribute);

        if (stat instanceof ValueStat) {
            value = ((ValueStat) stat).getValue();
        } else if (stat instanceof DerivedStat) {
            derived = ((DerivedStat) stat);
            if (stats.containsKey(derived.getAttribute())) {
                mainStat = stats.get(derived.getAttribute());
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
    public final Boolean hasStat(final String attribute) {
        return stats.containsKey(attribute);
    }

    @Override
    public final void removeAbility(final Ability ability) {
        abilities.remove(ability);
    }

    @Override
    public final void setStat(final String attribute, final Integer value) {
        final Stat stat;

        stat = stats.get(attribute);

        if (stat instanceof ValueStat) {
            ((ValueStat) stat).setValue(value);
        }
    }

}
