
package com.bernardomg.example.rpg.event;

import java.util.ArrayList;
import java.util.Collection;

public class DefaultEventHandler implements EventHandler {

    private final Collection<EventInterceptor> interceptors = new ArrayList<>();

    private Boolean                            lockFlag     = false;

    public DefaultEventHandler() {
        super();
    }

    @Override
    public void addEventInterceptor(final EventInterceptor interceptor) {
        interceptors.add(interceptor);
    }

    @Override
    public final void fireEvent(final Event event) {
        if (!lockFlag) {
            lockFlag = true;
            interceptors.stream().filter((i) -> i.accepts(event))
                    .forEach((i) -> i.onEvent(event));
            lockFlag = false;
        }
    }

}
