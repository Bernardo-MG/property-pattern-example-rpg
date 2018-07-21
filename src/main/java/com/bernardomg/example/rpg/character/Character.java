
package com.bernardomg.example.rpg.character;

import com.bernardomg.example.rpg.character.item.Equipment;
import com.bernardomg.example.rpg.character.stat.store.StatStore;

public interface Character extends StatStore {

    public void addAbility(final Ability ability);

    public void addEquipment(final Equipment item);

    public Iterable<Ability> getAbilities();

    public Iterable<Equipment> getEquipment();

    public void removeAbility(final Ability ability);

    public void removeEquipment(final Equipment item);

}
