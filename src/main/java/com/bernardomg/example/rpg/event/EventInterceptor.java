
package com.bernardomg.example.rpg.event;

public interface EventInterceptor {

    public Boolean accepts(final Event event);

    public void onEvent(final Event event);

}
