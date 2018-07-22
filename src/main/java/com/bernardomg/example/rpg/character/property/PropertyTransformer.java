
package com.bernardomg.example.rpg.character.property;

import java.util.function.Consumer;

import com.bernardomg.example.rpg.character.Character;

public interface PropertyTransformer {

    public void addFunction(final String property,
            final Consumer<Character> function);

    public void apply(final String property, final Character character);

}
