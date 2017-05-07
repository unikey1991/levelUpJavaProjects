package dao.impl;

import dao.AbstractDAO;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;

import static hiber.HibernateUtil.getSessionFactory;

/**
 * Created by unike on 03.05.2017.
 */
public class UserDAOImpl extends AbstractDAO<User>{

    public User mainUser = null;

    public void setMainUser(User mainUser) {
        this.mainUser = mainUser;
    }

    @Override
    public void create(User user) {
        transaction.begin();
        session.save(user);
        transaction.commit();
    }

    @Override
    public ArrayList<User> read() {
        Query userQuery = session.createQuery("from User", User.class);
        ArrayList<User> arrayList = (ArrayList<User>) userQuery.getResultList();
        return arrayList;
    }

    @Override
    public void update(User user) {
        transaction.begin();
        session.update(user);
        transaction.commit();
    }

    @Override
    public void delete(User user) {
        transaction.begin();
        session.delete(user);
        transaction.commit();
    }

    @Override
    public User getOneById(long id) {
        return null;
    }
}
