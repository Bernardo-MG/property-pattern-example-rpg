
package com.bernardomg.example.rpg.event;

public interface EventHandler {

    public void addEventInterceptor(final String eventName,
            final EventInterceptor interceptor);

    public void fireEvent(final String eventName, final Event event);

}
