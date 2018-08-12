
package com.bernardomg.example.rpg.event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Semaphore;

public class DefaultEventHandler implements EventHandler {

    private final Collection<EventInterceptor> interceptors = new ArrayList<>();

    private final Semaphore                    semaphore    = new Semaphore(1);

    public DefaultEventHandler() {
        super();
    }

    @Override
    public void addEventInterceptor(final EventInterceptor interceptor) {
        interceptors.add(interceptor);
    }

    @Override
    public final void fireEvent(final Event event) {
        if (semaphore.tryAcquire()) {
            interceptors.stream().filter((i) -> i.accepts(event))
                    .forEach((i) -> i.onEvent(event));
            semaphore.release();
        }
    }

}
