import java.sql.*;
import java.util.ArrayList;

/**
 * Created by unike on 18.03.2017.
 */
public class Main {
    private static final String LOGIN = "root";
    private static final String PASSWORD = "qwerty";
    private static final String DB_NAME = "factory";

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +
                    DB_NAME+"?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", LOGIN, PASSWORD);
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
//
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name_first = resultSet.getString("name_first");
//                String name_last = resultSet.getString("name_last");
//                String name_second = resultSet.getString("name_second");
//                int salary = resultSet.getInt("salary");
//                int department_id = resultSet.getInt("department_id");
//                int post_id = resultSet.getInt("post_id");
//                String date_create = resultSet.getString("date_create");
//                employees.add(new Employee(id, name_first, name_last, name_second, salary,department_id,post_id,date_create));
//                //System.out.println(resultSet.getLong("ID") + " " + resultSet.getString("name_first") + " " + resultSet.getString("name_last"));
//            }

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO EMPLOYEES (ID, NAME_FIRST, NAME_LAST) VALUES(?,?,?)");
            User user = new User("Bob","af@sdg.a", "asg");
            preparedStatement.setString(1,user.getName());

            preparedStatement.execute();




            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Employee e: employees){
            System.out.println(e.toString());
        }

    }
}
