package event;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {

    private final String event;

    public MyEvent(String event) {
        super(event);
        this.event = event;
    }

    public String getEvent() {
        return event;
    }
}
