import DAO.impl.CitizenDAOImpl;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by unike on 18.03.2017.
 */
public class Main {
    private static final String HOST = "unikey.hopto.org:3306/";
    private static final String USER = "unikey1991";
    private static final String PASSWORD = "qwerty";
    private static final String DATABASE = "address_book";
    private static final String PARAMETERS = "?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static void main(String[] args) {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://"+ HOST +
                    DATABASE+PARAMETERS, USER, PASSWORD);

            CitizenDAOImpl citizenDAO = new CitizenDAOImpl(connection);
            ArrayList citizenList = citizenDAO.read();
            System.out.println("complete");


            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
