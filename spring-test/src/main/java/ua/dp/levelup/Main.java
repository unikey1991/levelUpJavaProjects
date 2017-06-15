package ua.dp.levelup;

import com.google.gson.Gson;
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

        Car car1 = (Car) context.getBean("car1");
        Car car2 = (Car) context.getBean("car2");
        System.out.println(car1.toString());
        System.out.println(car2.toString());

        Gson gson = new Gson();

        System.out.println("json: "+ gson.toJson(car1));
        System.out.println("json: "+ gson.toJson(car2));




    }
}
