package event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyEventPublisher implements ApplicationContextAware {

    private ApplicationContext context;

    public void publishEvent(String event) {
        context.publishEvent(new MyEvent(event));
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
