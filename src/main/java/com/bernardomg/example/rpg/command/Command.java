
package com.bernardomg.example.rpg.command;

public interface Command {

    public void apply(final Object target);

    public void undo(final Object target);

    public Boolean valid(final Object target);

}
