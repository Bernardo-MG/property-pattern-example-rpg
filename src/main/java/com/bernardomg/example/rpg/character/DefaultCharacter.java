
package com.bernardomg.example.rpg.character;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import com.bernardomg.example.rpg.character.stat.Stat;
import com.bernardomg.example.rpg.character.stat.store.DefaultStatStore;
import com.bernardomg.example.rpg.character.stat.store.StatStore;

public final class DefaultCharacter implements Character {

    private final Collection<Ability> abilities = new ArrayList<>();

    private final StatStore           statStore = new DefaultStatStore();

    public DefaultCharacter() {
        super();
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
    public final Integer getStatValue(final String stat) {
        return statStore.getStatValue(stat);
    }

    @Override
    public final Boolean hasStat(final String stat) {
        return statStore.hasStat(stat);
    }

    @Override
    public final void removeAbility(final Ability ability) {
        abilities.remove(ability);
    }

    @Override
    public void removeStat(final String stat) {
        statStore.removeStat(stat);
    }

    @Override
    public final void setStat(final String stat, final Stat value) {
        statStore.setStat(stat, value);
    }

    @Override
    public final void setStatValue(final String stat, final Integer value) {
        statStore.setStatValue(stat, value);
    }

}
