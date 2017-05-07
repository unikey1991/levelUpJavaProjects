import hiber.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by java on 28.03.2017.
 */

import static hiber.HibernateUtil.getSessionFactory;

public class Main {

    public static void main(String[] args) {


        SessionFactory sessionFactory = getSessionFactory();
        //Employee employee = new Employee();

        try (Session session = sessionFactory.openSession()) {
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
            departmentQuery.setParameter("id", 1L);

            Department department = departmentQuery.uniqueResult();

            Query<Post> postQuery = session.createQuery("from Post where title = :title", Post.class);
            postQuery.setParameter("title", "Начальник департамента");

            Post post = postQuery.uniqueResult();
            System.out.println(post.toString());

            /*Employee employee = new Employee("Adolf","Ivanov","Robertovhich", 55000, department, post);

            employee.setSex(Sex.MALE);
            employee.setCity("Dnepr");
            employee.setStreetName("Krasnaya");
            employee.setZipCode("49000");

            Car car = new Car("BMW", Color.BLACK, 270);
            employee.setCar(car);

            PhoneNumber phoneNumber = new PhoneNumber("380930000000", employee);
*/
            //Yacht yacht = new Yacht("2247", 5, 10, 15);


            Transaction transaction = session.getTransaction();

            transaction.begin();
            /*employee.setPhoneNumber(phoneNumber);
            session.save(employee);
            session.save(phoneNumber);


            session.update(employee);*/

            /*Query<Employee> query = session.createQuery("from Employee", Employee.class);
            List<Employee> list = query.list();

            for (Employee e: list){
                System.out.println(e);
            }*/

           /* List<Yacht> list = Arrays.asList(
                    new Yacht("3567", 12, 15, 25),
                    new Yacht("4357", 12, 20, 25),
                    new Yacht("4387", 17, 20, 25),
                    new Yacht("4399", 17, 20, 25),
                    new Yacht("5504", 20, 25, 30),
                    new Yacht("2243", 4, 10, 25),
                    new Yacht("5522", 17, 25, 30),
                    new Yacht("5524", 17, 25, 30),
                    new Yacht("5547", 17, 25, 30),
                    new Yacht("1313", 2, 7, 15),
                    new Yacht("7766", 22, 35, 35),
                    new Yacht("2247", 5, 10, 15),
                    new Yacht("1248", 14, 100, 5),
                    new Yacht("2247", 55, 15, 25),
                    new Yacht("4347", 15, 10, 25),
                    new Yacht("4377", 12, 15, 35),
                    new Yacht("5508", 10, 16, 45),
                    new Yacht("2197", 11, 20, 25),
                    new Yacht("2241", 99, 100, 115),
                    new Yacht("2242", 17, 60, 115),
                    new Yacht("2233", 18, 7, 145),
                    new Yacht("2948", 22, 35, 25),
                    new Yacht("1248", 14, 100, 5)
            );

            for (Boat b:list) {
                session.save(b);
            }

            transaction.commit();*/

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

            CriteriaQuery<Yacht> criteriaQuery = criteriaBuilder.createQuery(Yacht.class);
            Root<Yacht> yachtRoot = criteriaQuery.from(Yacht.class);


            //selectAllBoatsOrderBySpeed(criteriaBuilder,criteriaQuery,yachtRoot,sessionFactory);
            //selectOneByMaxSpeed(criteriaBuilder,criteriaQuery,yachtRoot,sessionFactory);
            //selectOneByMin(criteriaBuilder, criteriaQuery, yachtRoot, sessionFactory);


        } finally {
            sessionFactory.close();
            System.out.println("Good bye");
        }
    }

    private static void selectOneByMin(CriteriaBuilder criteriaBuilder, CriteriaQuery<Yacht> criteriaQuery, Root<Yacht> yachtRoot, SessionFactory sessionFactory) {
        criteriaQuery.select(yachtRoot);
        criteriaQuery.orderBy(criteriaBuilder.asc(yachtRoot.get("maxPassengers")));

        EntityManager entityManager = sessionFactory.createEntityManager();
        Yacht yacht = entityManager.createQuery(criteriaQuery).setMaxResults(1).getSingleResult();

        System.out.println(yacht);
    }


    private static void selectOneByMaxSpeed(CriteriaBuilder criteriaBuilder, CriteriaQuery<Yacht> criteriaQuery, Root<Yacht> yachtRoot, SessionFactory sessionFactory) {

        criteriaQuery.select(yachtRoot);
        criteriaQuery.orderBy(criteriaBuilder.desc(yachtRoot.get("maxSpeed")));
        EntityManager entityManager = sessionFactory.createEntityManager();
        Yacht yach = entityManager.createQuery(criteriaQuery).setMaxResults(1).getSingleResult();
        System.out.println(yach.toString());

    }


    private static void selectAllBoatsOrderBySpeed(CriteriaBuilder criteriaBuilder, CriteriaQuery<Yacht> criteriaQuery, Root<Yacht> yachtRoot, SessionFactory sessionFactory) {
        criteriaQuery.select(yachtRoot);
        criteriaQuery.orderBy(criteriaBuilder.asc(yachtRoot.get("maxSpeed")));

        EntityManager entityManager = sessionFactory.createEntityManager();
        List<Yacht> resultList = entityManager.createQuery(criteriaQuery).getResultList();

        for (Yacht y : resultList) {
            System.out.println(y);
        }
    }
}
