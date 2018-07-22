
package com.bernardomg.example.rpg.character.property;

public interface Command<T> {

    public void apply(final T target);

    public void undo(final T target);

}
