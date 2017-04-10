import hiber.*;
import hiber.Color;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.CriteriaSubqueryImpl;

import javax.persistence.criteria.*;
import java.awt.*;
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

//            Transaction transaction = session.getTransaction();
//
//            transaction.begin();
//            //session.save(employee);
//            transaction.commit();
//
//            Query<Employee> query = session.createQuery("from Employee", Employee.class);
//            List<Employee> list = query.list();
//
//            for (Employee e: list){
//                System.out.println(e);
//            }
//
//            Query<WorkingDays> query1 = session.createQuery("from WorkingDays ", WorkingDays.class);
//            List<WorkingDays> list1 = query1.list();
//
//            for (WorkingDays e: list1){
//                System.out.println(e);
//            }


            Query<Department> departmentQuery = session.createQuery("from Department where id = :id", Department.class);
            departmentQuery.setParameter("id",1L);

            Department department = departmentQuery.uniqueResult();

            Query<Post> postQuery = session.createQuery("from Post where id = :id", Post.class);
            postQuery.setParameter("id",1L);

            Post post = postQuery.uniqueResult();

            /*Employee employee = new Employee("Adolf","Ivanov","Robertovhich", 55000, department, post);

            employee.setSex(Sex.MALE);
            employee.setCity("Dnepr");
            employee.setStreetName("Krasnaya");
            employee.setZipCode("49000");

            Car car = new Car("BMW", Color.BLACK, 270);
            employee.setCar(car);

            PhoneNumber phoneNumber = new PhoneNumber("380930000000", employee);
*/
            Yacht yacht = new Yacht("2247", 5, 10, 15);


            Transaction transaction = session.getTransaction();

            transaction.begin();
            /*employee.setPhoneNumber(phoneNumber);
            session.save(employee);
            session.save(phoneNumber);


            session.update(employee);*/

            session.save(yacht);
            transaction.commit();

            /*Query<Employee> query = session.createQuery("from Employee", Employee.class);
            List<Employee> list = query.list();

            for (Employee e: list){
                System.out.println(e);
            }*/

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Yacht> criteriaQuery = session.getCriteriaBuilder().createQuery(Yacht.class);
            Root<Yacht> yachtRoot = criteriaQuery.from(Yacht.class);
            Predicate predicate = criteriaBuilder.equal(yachtRoot.get("model"),"2247");

            CriteriaQuery<Yacht> query = criteriaQuery.where(predicate);
        } finally  {
            sessionFactory.close();
            System.out.println("Good bye");
        }













    }
}
