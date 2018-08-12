
package com.bernardomg.example.rpg.property;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

import com.bernardomg.example.rpg.command.Command;

public class DefaultPropertyExecutor implements PropertyExecutor {

    private final Map<String, Semaphore>                 semaphores   = new HashMap<>();

    private final Map<String, Command<? extends Object>> transformers = new HashMap<>();

    public DefaultPropertyExecutor() {
        super();
        // TODO: Support collections of commands?
    }

    @Override
    public void addFunction(final String property,
            final Command<? extends Object> function) {
        transformers.put(property, function);
        semaphores.put(property, new Semaphore(1));
    }

    @Override
    public void apply(final String property, final Object target) {
        final Command command;

        if ((transformers.containsKey(property))
                && (semaphores.get(property).tryAcquire())) {
            command = (transformers.get(property));
            if (command.valid(target)) {
                command.apply(target);
            }
            semaphores.get(property).release();
        }
    }

    @Override
    public void undo(final String property, final Object target) {
        final Command command;

        if ((transformers.containsKey(property))
                && (semaphores.get(property).tryAcquire())) {
            command = (transformers.get(property));
            if (command.valid(target)) {
                command.undo(target);
            }
            semaphores.get(property).release();
        }
    }

}
