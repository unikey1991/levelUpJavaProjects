package ua.dp.levelup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by unity on 13.06.2017.
 */
public class Main {

    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Greeting greetingBean = context.getBean(Greeting.class);
        greetingBean.sayHello();


    }
}
