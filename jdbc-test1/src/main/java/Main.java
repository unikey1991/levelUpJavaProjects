import java.sql.*;

/**
 * Created by unike on 18.03.2017.
 */
public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +
                    "address_book?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "qwerty");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM CITIZEN");

            while (resultSet.next()) {
                System.out.println(resultSet.getLong("ID") + " " + resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
            }

            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
