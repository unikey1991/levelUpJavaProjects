package dao;

import entity.User;
import hiber.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

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

    public User getUserById(long id){
        Transaction transaction = null;
        try (Session session = HibernateUtil.openSession()) {
            Query<User> userQuery = session.createQuery("from User where id =:id", User.class);
            userQuery.setParameter("id", id);
            return userQuery.getSingleResult();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error deleteById");
        }
        return null;
    }

    public void delete(User user){
        Transaction transaction = null;
        try (Session session = HibernateUtil.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.delete(user);
            transaction.commit();
            System.out.println("\n\n User deleted \n");

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error deleteById");
        }
    }

    public void update(User user){
        Transaction transaction = null;
        try (Session session = HibernateUtil.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.update(user);
            transaction.commit();
            System.out.println("\n\n User updated \n");

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error updateById");
        }
    }

    public List<User> getUsersListByLoginAndPhone (String login, String phone){
        try (Session session = HibernateUtil.openSession()) {
            Query<User> userQuery = session.createQuery("from User where login like :login and phone like :phone", User.class);
            userQuery.setParameter("login", "%"+login+"%");
            userQuery.setParameter("phone", "%"+phone+"%");
            return userQuery.getResultList();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error getUsersListByLoginAndPhone");
        }
        return null;
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
            System.out.println("error getUserByLoginAndPassword");
        }
        return null;
    }
}
