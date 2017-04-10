package hiber;

import org.hibernate.SessionFactory;


/**
 * Created by unike on 10.04.2017.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory = null;

    static {
        try {
//creates the session factory from hibernate.cfg.xml
            sessionFactory = new
                    org.hibernate.cfg.Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
