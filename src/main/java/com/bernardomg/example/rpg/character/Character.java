
package com.bernardomg.example.rpg.character;

import com.bernardomg.example.rpg.character.stat.store.StatStore;

public interface Character extends StatStore {

    public void addAbility(final Ability ability);

    public Iterable<Ability> getAbilities();

    public void removeAbility(final Ability ability);

}
