
package com.bernardomg.example.rpg.character.builder;

import com.bernardomg.example.rpg.character.Character;
import com.bernardomg.example.rpg.character.DefaultCharacter;
import com.bernardomg.example.rpg.character.attribute.DefaultValueStat;
import com.bernardomg.example.rpg.character.attribute.MultipliedDerivedStat;

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
        character.addStat(name, new DefaultValueStat());

        return this;
    }

    @Override
    public final CharacterBuilder withMultipliedDerivedAttribute(
            final String name, final String root, final Integer mult) {
        character.addStat(name, new MultipliedDerivedStat(root, mult));

        return this;
    }

}
