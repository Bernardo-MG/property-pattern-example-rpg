
package com.bernardomg.example.rpg.character.property;

import com.bernardomg.example.rpg.character.stat.store.StatStore;
import com.bernardomg.example.rpg.command.Command;

public interface PropertyExecutor {

    public void addFunction(final String property,
            final Command<StatStore> function);

    public void apply(final String property, final StatStore character);

    public void undo(final String property, final StatStore character);

}
