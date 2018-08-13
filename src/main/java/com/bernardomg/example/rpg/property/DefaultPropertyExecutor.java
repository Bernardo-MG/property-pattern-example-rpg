
package com.bernardomg.example.rpg.property;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.function.BiConsumer;

import com.bernardomg.example.rpg.command.Command;

public final class DefaultPropertyExecutor implements PropertyExecutor {

    private final Map<String, Semaphore> semaphores   = new HashMap<>();

    private final Map<String, Command>   transformers = new HashMap<>();

    public DefaultPropertyExecutor() {
        super();
        // TODO: Support collections of commands?
    }

    @Override
    public final void addFunction(final String property,
            final Command function) {
        transformers.put(property, function);
        semaphores.put(property, new Semaphore(1));
    }

    @Override
    public final void apply(final String property, final Object target) {
        doAction(property, target,
                (final Command c, final Object i) -> c.apply(i));
    }

    @Override
    public final void undo(final String property, final Object target) {
        doAction(property, target,
                (final Command c, final Object i) -> c.undo(i));
    }

    private final void doAction(final String property, final Object target,
            final BiConsumer<Command, Object> operation) {
        final Command command;
        final Boolean exists;

        exists = transformers.containsKey(property);
        if ((exists) && (semaphores.get(property).tryAcquire())) {
            command = transformers.get(property);
            if (command.valid(target)) {
                operation.accept(command, target);
            }
            semaphores.get(property).release();
        }
    }

}
