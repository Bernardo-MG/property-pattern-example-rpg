
package com.bernardomg.example.rpg.character.builder;

import java.util.function.Consumer;

import com.bernardomg.example.rpg.character.Character;

public interface CharacterBuilder {

    public Character get();

    public CharacterBuilder registerProperty(final String property,
            final Consumer<Character> function);

    public CharacterBuilder withAttribute(final String name);

    public CharacterBuilder withItemSlot(final String name);

    public CharacterBuilder withMultipliedDerivedAttribute(final String name,
            final String root, final Integer mult);

}
