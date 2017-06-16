package ua.dp.levelup;

import com.google.gson.Gson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by unity on 13.06.2017.
 */
public class Main {

    public static void main(String[] args) {


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Gson gson = new Gson();

        /////////////////////////
        /*Car car1 = (Car) context.getBean("car1");
        Car car2 = (Car) context.getBean("car2");

        System.out.println("json: " + gson.toJson(car1));
        System.out.println("json: " + gson.toJson(car2));*/

        ///////////////////////////
        /*Pc pc1 = (Pc) context.getBean("PC1");
        User user1 = (User) context.getBean("user1");

        System.out.println(gson.toJson(pc1));
        System.out.println(gson.toJson(user1));*/

        //////////////////

        context.close();

        ////////////


        UserService userService = (UserService) context.getBean("userService1");
        userService.doMagic();


    }
}
