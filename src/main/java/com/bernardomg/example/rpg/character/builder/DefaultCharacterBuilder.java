
package com.bernardomg.example.rpg.character.builder;

import com.bernardomg.example.rpg.character.Character;
import com.bernardomg.example.rpg.character.DefaultCharacter;
import com.bernardomg.example.rpg.character.stat.DefaultValueStat;
import com.bernardomg.example.rpg.character.stat.MultipliedDerivedStat;

public final class DefaultCharacterBuilder implements CharacterBuilder {

    private final Character character;

    public DefaultCharacterBuilder() {
        super();

        character = new DefaultCharacter();
    }

    @Override
    public final Character get() {
        return character;
    }

    @Override
    public final CharacterBuilder withAttribute(final String name) {
        character.setStat(name, new DefaultValueStat());

        return this;
    }

    @Override
    public final CharacterBuilder withMultipliedDerivedAttribute(
            final String name, final String root, final Integer mult) {
        character.setStat(name, new MultipliedDerivedStat(root, mult));

        return this;
    }

}
