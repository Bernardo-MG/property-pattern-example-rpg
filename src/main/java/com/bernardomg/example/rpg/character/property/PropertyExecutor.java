
package com.bernardomg.example.rpg.character.property;

import com.bernardomg.example.rpg.character.Character;

public interface PropertyExecutor {

    public void addFunction(final String property,
            final Command<Character> function);

    public void apply(final String property, final Character character);

    public void undo(final String property, final Character character);

}
