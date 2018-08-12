
package com.bernardomg.example.rpg.event;

public interface EventInterceptor<E extends Event> {

    public Boolean accepts(final E event);

    public void onEvent(final E event);

}
