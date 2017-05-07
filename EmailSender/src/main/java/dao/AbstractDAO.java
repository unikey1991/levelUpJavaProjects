package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;

import static hiber.HibernateUtil.getSessionFactory;

/**
 * Created by unike on 03.05.2017.
 */
public abstract class AbstractDAO<T> {

    SessionFactory sessionFactory = getSessionFactory();
    public Session session = sessionFactory.openSession();
    public Transaction transaction = session.getTransaction();


    public abstract void create(T t);

    public abstract ArrayList<T> read();

    public abstract void update(T t);

    public abstract void delete(T t);

    public abstract T getOneById(long id);

}
