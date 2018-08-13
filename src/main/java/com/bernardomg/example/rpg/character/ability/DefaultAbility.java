
package com.bernardomg.example.rpg.character.ability;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public final class DefaultAbility implements Ability {

    private final String             name;

    private final Collection<String> properties = new ArrayList<>();

    public DefaultAbility(final String abilityName) {
        super();

        name = abilityName;
    }

    @Override
    public final void addProperty(final String property) {
        properties.add(property);
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final Collection<String> getProperties() {
        return Collections.unmodifiableCollection(properties);
    }

    @Override
    public final Boolean hasProperty(final String name) {
        return properties.contains(name);
    }

    @Override
    public final void removeProperty(final String property) {
        properties.remove(property);
    }

}
