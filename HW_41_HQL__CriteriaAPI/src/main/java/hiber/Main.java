package hiber;


import hiber.hw35.Citizen;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

import java.util.List;
import java.util.Set;

import static hiber.HibernateUtil.getSessionFactory;

/**
 * Created by unike on 10.04.2017.
 */
public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = getSessionFactory();
        try (Session session = sessionFactory.openSession()) {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

            CriteriaQuery<Citizen> criteriaQuery = criteriaBuilder.createQuery(Citizen.class);
            Root<Citizen> citizenRoot = criteriaQuery.from(Citizen.class);

            //getSumOfCitizens(criteriaBuilder, criteriaQuery, citizenRoot, sessionFactory);
            //getAVGAgeOfCitizens(criteriaBuilder, criteriaQuery, citizenRoot, sessionFactory);
            //selectAllCitizensByLastNameWhithoutRepeat(criteriaBuilder, criteriaQuery, citizenRoot, sessionFactory);
            selectAllCitizensByLastNameWhithNumOfRepeat(criteriaBuilder, sessionFactory);


        } finally {
            sessionFactory.close();
            System.out.println("Good by");
        }
    }

    //1.	Вывести общее число жителей
    private static void getSumOfCitizens(CriteriaBuilder criteriaBuilder, CriteriaQuery<Citizen> criteriaQuery, Root<Citizen> citizenRoot, SessionFactory sessionFactory) {
        criteriaQuery.select(citizenRoot);
        EntityManager entityManager = sessionFactory.createEntityManager();
        int count = entityManager.createQuery(criteriaQuery).getResultList().size();
        System.out.println(count);
    }

    //2.	Вывести средний возраст жителей
    private static void getAVGAgeOfCitizens(CriteriaBuilder criteriaBuilder, CriteriaQuery<Citizen> criteriaQuery, Root<Citizen> citizenRoot, SessionFactory sessionFactory) {
        Expression avg = criteriaBuilder.avg(citizenRoot.<Number>get("age"));
        criteriaQuery.select(avg);
        EntityManager entityManager = sessionFactory.createEntityManager();
        System.out.println(entityManager.createQuery(criteriaQuery).getSingleResult());
    }

    //3.	Вывести отсортированный по алфавиту список фамилий без повторений
    private static void selectAllCitizensByLastNameWhithoutRepeat(CriteriaBuilder criteriaBuilder, CriteriaQuery<Citizen> criteriaQuery, Root<Citizen> citizenRoot, SessionFactory sessionFactory) {
        criteriaQuery.select(citizenRoot);
        criteriaQuery.orderBy(criteriaBuilder.asc(citizenRoot.get("lastName")));
        criteriaQuery.groupBy(citizenRoot.get("lastName"));

        EntityManager entityManager = sessionFactory.createEntityManager();
        List<Citizen> resultList = entityManager.createQuery(criteriaQuery).getResultList();

        for (Citizen y : resultList) {
            System.out.println(y);
        }
    }

    //4.	Вывести список фамилий, с указанием количества повторений этих фамилий в общем списке
    private static void selectAllCitizensByLastNameWhithNumOfRepeat(CriteriaBuilder criteriaBuilder, SessionFactory sessionFactory) {
        CriteriaQuery<Citizen> query = criteriaBuilder.createQuery(Citizen.class);
        Root<Citizen> u = query.from(Citizen.class);

        query.multiselect(u.get("lastName"), criteriaBuilder.count(u.get("lastName"))).groupBy(u.get("lastName"));

        EntityManager entityManager = sessionFactory.createEntityManager();
        List list = entityManager.createQuery(query).getResultList();

        for (Citizen c : list){
            System.out.println(c.toString());
        }
    }



}
