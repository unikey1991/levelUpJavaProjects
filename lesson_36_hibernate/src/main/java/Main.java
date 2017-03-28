import hiber.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by java on 28.03.2017.
 */

import static hiber.HibernateUtil.getSessionFactory;

public class Main {
    private static final String HOST = "unikey.hopto.org:3306/";
    private static final String USER = "unikey1991";
    private static final String PASSWORD = "qwerty12345";
    private static final String DATABASE = "address_book";
    private static final String PARAMETERS = "?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection connection = DriverManager.getConnection("jdbc:mysql://" + HOST +
//                DATABASE + PARAMETERS, USER, PASSWORD);


        SessionFactory sessionFactory = getSessionFactory();

//        Session session = sessionFactory.openSession();
//
//        session.createQuery("", User.class);
    }
}
