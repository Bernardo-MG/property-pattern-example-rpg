
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
    }

    @Override
    public void addFunction(final String property,
            final Command<? extends Object> function) {
        transformers.put(property, function);
        semaphores.put(property, new Semaphore(1));
    }

    @Override
    public void apply(final String property, final Object target) {
        if ((transformers.containsKey(property))
                && (semaphores.get(property).tryAcquire())) {
            ((Command) transformers.get(property)).apply(target);
            semaphores.get(property).release();
        }
    }

    @Override
    public void undo(final String property, final Object target) {
        if ((transformers.containsKey(property))
                && (semaphores.get(property).tryAcquire())) {
            ((Command) transformers.get(property)).undo(target);
            semaphores.get(property).release();
        }
    }

}
