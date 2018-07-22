
package com.bernardomg.example.rpg.character.ability;

import java.util.Collection;

public interface Ability {

    public void addProperty(final String property);

    public String getName();

    public Collection<String> getProperties();

    public void removeProperty(final String property);

}
