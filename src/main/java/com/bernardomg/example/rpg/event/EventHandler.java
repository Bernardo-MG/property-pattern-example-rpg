
package com.bernardomg.example.rpg.event;

public interface EventHandler {

    public void addEventInterceptor(final EventInterceptor interceptor);

    public void fireEvent(final Event event);

}
