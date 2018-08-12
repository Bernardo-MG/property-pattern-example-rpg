
package com.bernardomg.example.rpg.property;

import com.bernardomg.example.rpg.command.Command;

public interface PropertyExecutor {

    public void addFunction(final String property,
            final Command<? extends Object> function);

    public void apply(final String property, final Object target);

    public void undo(final String property, final Object target);

}
