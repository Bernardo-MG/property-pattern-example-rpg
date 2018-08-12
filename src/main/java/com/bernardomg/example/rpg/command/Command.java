
package com.bernardomg.example.rpg.command;

public interface Command<T> {

    public void apply(final T target);

    public void undo(final T target);

}
