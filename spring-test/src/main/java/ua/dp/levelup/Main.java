package ua.dp.levelup;

import com.google.gson.Gson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.dp.levelup.dao.UserDAO;
import ua.dp.levelup.service.UserService;

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

        /*context.close();*/

        ////////////


        /*UserServiceImpl userService = (UserServiceImpl) context.getBean("userService1");
        userService.doMagic();*/

        TestScope testScope1 = (TestScope) context.getBean("testScope1");
        testScope1.setText("her");
        testScope1.print();

        TestScope testScope2 = (TestScope) context.getBean("testScope1");
        testScope2.print();


        Message bean1 = (Message) context.getBean("singleton-message");
        Message bean2 = (Message) context.getBean("singleton-message");
        Message bean3 = (Message) context.getBean("singleton-message");

        Message bean4 = (Message) context.getBean("prototype-message");
        Message bean5 = (Message) context.getBean("prototype-message");
        Message bean6 = (Message) context.getBean("prototype-message");


        System.out.println(bean1 + ": ");
        bean1.print();

        System.out.println(bean2 + ": ");
        bean2.print();

        System.out.println(bean3 + ": ");
        bean3.print();

        System.out.println(bean4 + ": ");
        bean4.print();

        System.out.println(bean5 + ": ");
        bean5.print();

        System.out.println(bean6 + ": ");
        bean6.print();

        /////////////////

        UserService userService = (UserService) context.getBean("userService");

        User user1 = userService.getUserById(2L);

        System.out.println(user1.toString());
    }
}
