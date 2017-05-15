package dao;

import entity.User;
import hiber.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * Created by unike on 15.05.2017.
 */
public class UserDAO {


    public void addUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.save(user);
            transaction.commit();
            System.out.println("\n\n Details Added \n");

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error addUser");
        }
    }

    public User getUserByLoginAndPassword(String login, String password) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.openSession()) {
            Query<User> userQuery = session.createQuery("from User where login = :login and password = :password", User.class);
            userQuery.setParameter("login", login);
            userQuery.setParameter("password", password);
            User user = userQuery.getSingleResult();
            if (null != user) return user;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error getUser");
        }
        return null;
    }
}
