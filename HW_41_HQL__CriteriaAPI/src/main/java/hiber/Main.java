package hiber;


import hiber.hw35.Citizen;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.ResultSet;
import java.util.List;

import static hiber.HibernateUtil.getSessionFactory;

/**
 * Created by unike on 10.04.2017.
 */
public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = getSessionFactory();
        try (Session session = sessionFactory.openSession()){

            Query<Citizen> query = session.createQuery("from Citizen", Citizen.class);

            List<Citizen> list = query.list();
            //1.	Вывести общее число жителей
            System.out.println("Citizens count = "+list.size());

            //2.	Вывести средний возраст жителей
            int age = 0;
            for (Citizen c:list){
                age += c.getAge();
            }
            System.out.println(age/list.size());

            //3.	Вывести отсортированный по алфавиту список фамилий без повторений
            Query<Citizen> query3 = session.createQuery("from Citizen group by lastName order by lastName", Citizen.class);
            List<Citizen> list3 = query3.list();
            for (Citizen c:list3){
                System.out.println(c.toString());
            }

            //4.	Вывести список фамилий, с указанием количества повторений этих фамилий в общем списке
            Query query4 = session.createQuery("from Citizen " +
                    "group by lastName");

            //5.	Вывести фамилии, которые содержат в середине букву «n»



            System.out.println("5.\tВывести фамилии, которые содержат в середине букву «n»");
            CriteriaBuilder builder5 = session.getCriteriaBuilder();
            CriteriaQuery<Citizen> criteria5 = builder5.createQuery(Citizen.class);
            Root<Citizen> root5 = criteria5.from(Citizen.class);
            criteria5.select(root5);
            criteria5.where(builder5.equal(root5.get("lastName"),"Мороз"));

            List<Citizen> list5 = session.createQuery(criteria5).getResultList();

            /*Query<Citizen> query5 = session.createQuery("from Citizen where lastName like '%n%'", );
            List<Citizen> list5 = query5.list();*/
            for (Citizen c:list5){
                System.out.println(c.toString());
            }



            //select last_name, count(last_name) as count from address_book.citizen group by last_name





        } finally {
            sessionFactory.close();
            System.out.println("Good by");
        }
    }
}
