import java.sql.*;

/**
 * Created by java on 17.03.2017.
 */

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/forum?","root","qwerty");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM USER");

        while (resultSet.next()) {
            System.out.println(resultSet.getLong("id")
                    + " " + resultSet.getString("user_name")
                    + " " + resultSet.getString("email"));
        }

        connection.close();

    }
}
