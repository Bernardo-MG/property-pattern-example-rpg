
package com.bernardomg.example.rpg.character.builder;

import com.bernardomg.example.rpg.character.Character;

public interface CharacterBuilder {

    public Character get();

    public CharacterBuilder withAttribute(final String name);

    public CharacterBuilder withItemSlot(final String name);

    public CharacterBuilder withMultipliedDerivedAttribute(final String name,
            final String root, final Integer mult);

}
