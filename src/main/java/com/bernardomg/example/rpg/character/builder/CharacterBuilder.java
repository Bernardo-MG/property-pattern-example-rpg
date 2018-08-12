
package com.bernardomg.example.rpg.character.builder;

import com.bernardomg.example.rpg.character.Character;
import com.bernardomg.example.rpg.command.Command;
import com.bernardomg.example.rpg.event.EventInterceptor;

public interface CharacterBuilder {

    public Character get();

    public CharacterBuilder registerProperty(final String property,
            final Command<? extends Object> function);

    public CharacterBuilder withAttribute(final String name);

    public CharacterBuilder
            withEquipItemEventInterceptor(final EventInterceptor interceptor);

    public CharacterBuilder withItemSlot(final String name);

    public CharacterBuilder withMultipliedDerivedAttribute(final String name,
            final String root, final Integer mult);

}
