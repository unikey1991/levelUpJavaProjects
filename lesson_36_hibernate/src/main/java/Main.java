import hiber.*;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by java on 28.03.2017.
 */

import static hiber.HibernateUtil.getSessionFactory;

public class Main {

    public static void main(String[] args) {


        SessionFactory sessionFactory = getSessionFactory();
        //Employee employee = new Employee();

        try (Session session = sessionFactory.openSession()){
            //Employee employee = new Employee("Andrey", "Ivanov", "Robertovich",50000);

            Transaction transaction = session.getTransaction();

            transaction.begin();
            //session.save(employee);
            transaction.commit();

            Query<Employee> query = session.createQuery("from Employee", Employee.class);
            List<Employee> list = query.list();

            for (Employee e: list){
                System.out.println(e);
            }

            Query<WorkingDays> query1 = session.createQuery("from WorkingDays ", WorkingDays.class);
            List<WorkingDays> list1 = query1.list();

            for (WorkingDays e: list1){
                System.out.println(e);
            }


        } finally  {
            sessionFactory.close();
            System.out.println("Good bye");
        }





    }
}
