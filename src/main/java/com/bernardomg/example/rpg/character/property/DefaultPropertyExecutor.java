
package com.bernardomg.example.rpg.character.property;

import java.util.HashMap;
import java.util.Map;

import com.bernardomg.example.rpg.character.Character;

public class DefaultPropertyExecutor implements PropertyExecutor {

    private final Map<String, Command<Character>> transformers = new HashMap<>();

    public DefaultPropertyExecutor() {
        super();
    }

    @Override
    public void addFunction(final String property,
            final Command<Character> function) {
        transformers.put(property, function);
    }

    @Override
    public void apply(final String property, final Character character) {
        transformers.get(property).apply(character);
    }

    @Override
    public void undo(final String property, final Character character) {
        transformers.get(property).undo(character);
    }

}
