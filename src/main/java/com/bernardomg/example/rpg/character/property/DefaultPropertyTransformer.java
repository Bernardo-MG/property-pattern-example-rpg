
package com.bernardomg.example.rpg.character.property;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import com.bernardomg.example.rpg.character.Character;

public class DefaultPropertyTransformer implements PropertyTransformer {

    private final Map<String, Consumer<Character>> transformers = new HashMap<>();

    public DefaultPropertyTransformer() {
        super();
    }

    @Override
    public void addFunction(final String property,
            final Consumer<Character> function) {
        transformers.put(property, function);
    }

    @Override
    public void apply(final String property, final Character character) {
        transformers.get(property).accept(character);
    }

}
