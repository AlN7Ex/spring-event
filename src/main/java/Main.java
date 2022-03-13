import event.MyEventPublisher;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;
import java.util.Scanner;

public class Main implements ApplicationContextAware {

    public static void main(String[] args) {
        System.out.println("Hello");

        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int findMe = rand.nextInt(10 + 1);
        System.out.println(findMe);

        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        MyEventPublisher publisher = context.getBean("myEventPublisher", MyEventPublisher.class);

        publisher.publishEvent("Привет, я загадал число, попробуй его отгадать!");
        publisher.publishEvent("Делай попытку, можно вводить числа от 0 до 1000!");

        while (true) {
            int num = input.nextInt();
            if (findMe > num) {
                publisher.publishEvent("Моё число больше твоего");
            }
            else if (findMe < num) {
                publisher.publishEvent("Моё число больше твоего");
            }
            else {
                publisher.publishEvent("Ты угадал, я загадал число " + findMe);
                break;
            }
        }



    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
