
package com.bernardomg.example.rpg.character.property.store;

import java.util.Collection;

public interface PropertyStore {

    public void addProperty(final String name);

    public Collection<String> getProperties();

    public Boolean hasProperty(final String name);

    public void removeProperty(final String name);

}
