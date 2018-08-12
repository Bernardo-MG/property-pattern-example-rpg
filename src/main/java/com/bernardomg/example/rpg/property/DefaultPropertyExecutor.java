
package com.bernardomg.example.rpg.property;

import java.util.HashMap;
import java.util.Map;

import com.bernardomg.example.rpg.character.stat.store.StatStore;
import com.bernardomg.example.rpg.command.Command;

public class DefaultPropertyExecutor implements PropertyExecutor {

    private final Map<String, Command<StatStore>> transformers = new HashMap<>();

    public DefaultPropertyExecutor() {
        super();
    }

    @Override
    public void addFunction(final String property,
            final Command<StatStore> function) {
        transformers.put(property, function);
    }

    @Override
    public void apply(final String property, final StatStore character) {
        transformers.get(property).apply(character);
    }

    @Override
    public void undo(final String property, final StatStore character) {
        transformers.get(property).undo(character);
    }

}
