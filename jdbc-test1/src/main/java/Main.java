import DAO.impl.CitizenDAOImpl;
import entity.Citizen;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by unike on 18.03.2017.
 */
public class Main {
    private static final String LOGIN = "unikey1991";
    private static final String PASSWORD = "qwerty";
    private static final String DB_NAME = "address_book";

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://unikey.hopto.org:3306/" +
                    DB_NAME+"?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", LOGIN, PASSWORD);




            CitizenDAOImpl citizenDAO = new CitizenDAOImpl(connection);
            ArrayList citizenList = citizenDAO.read();
            System.out.println("complete");


            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Employee e: employees){
            System.out.println(e.toString());
        }

    }
}
