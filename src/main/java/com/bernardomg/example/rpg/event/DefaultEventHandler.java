
package com.bernardomg.example.rpg.event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class DefaultEventHandler implements EventHandler {

    private final Map<String, Collection<EventInterceptor>> interceptors = new HashMap<>();

    private final Semaphore                                 semaphore    = new Semaphore(
            1);

    public DefaultEventHandler() {
        super();
    }

    @Override
    public void addEventInterceptor(final String eventName,
            final EventInterceptor interceptor) {
        if (!interceptors.containsKey(eventName)) {
            interceptors.put(eventName, new ArrayList<>());
        }

        interceptors.get(eventName).add(interceptor);
    }

    @Override
    public final void fireEvent(final String eventName, final Event event) {
        if ((interceptors.containsKey(eventName)) && (semaphore.tryAcquire())) {
            interceptors.get(eventName).stream().filter((i) -> i.accepts(event))
                    .forEach((i) -> i.onEvent(event));
            semaphore.release();
        }
    }

}
