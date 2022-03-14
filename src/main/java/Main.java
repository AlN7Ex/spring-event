import event.MyEventPublisher;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main implements ApplicationContextAware {

    public static void main(String[] args) {
        Locale locale = Locale.US; // or Locale.getDefault()

        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int findMe = rand.nextInt(1000 + 1);
        System.out.println(findMe);

        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        MyEventPublisher publisher = context.getBean("myEventPublisher", MyEventPublisher.class);

        publisher.publishEvent(context.getMessage("greetings",null, locale));
        publisher.publishEvent(context.getMessage("task",null, locale));

        while (true) {
            int num = input.nextInt();
            if (findMe > num) {
                publisher.publishEvent(context.getMessage("greaterNumber",null, locale));
            }
            else if (findMe < num) {
                publisher.publishEvent(context.getMessage("lessNumber",null, locale));
            }
            else {
                publisher.publishEvent(context.getMessage("guessedNumber",null, locale) + " " + findMe);
                break;
            }
        }



    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
