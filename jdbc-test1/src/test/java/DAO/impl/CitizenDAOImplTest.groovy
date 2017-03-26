package DAO.impl

import entity.Citizen
import sun.applet.Main

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement


/**
 * Created by unike on 26.03.2017.
 */
class CitizenDAOImplTest extends spock.lang.Specification {


    private static final String HOST = "unikey.hopto.org:3306/";
    private static final String USER = "unikey1991";
    private static final String PASSWORD = "qwerty12345";
    private static final String DATABASE = "address_book";
    private static final String PARAMETERS = "?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    Connection connection = DriverManager.getConnection("jdbc:mysql://"+ HOST +
            DATABASE+PARAMETERS, USER, PASSWORD);
    CitizenDAOImpl citizenDAO = new CitizenDAOImpl(connection);


    def "Create"() {
        given: "create object of Citizen"
        Citizen citizen = new Citizen("Jason", "Statham", 49L,4L)

        when: "add citizen to DB"
        citizenDAO.create(citizen);

        then: "check DB & id"
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM citizen where id="+citizen.getId());
        resultSet.next();
        resultSet.getString("first_name") == "Jason";
        resultSet.getString("last_name") == "Statham";
        resultSet.getLong("age") == 49L
        resultSet.getLong("street_id") == 4L

        citizenDAO.delete(citizen)
    }

    def "Create crash"() {
        given: "create object of Citizen = null"
        Citizen citizen = null;

        when: "add null citizen to DB"
        citizenDAO.create(citizen);

        then: "work without exception"

    }

    def "Update"() {

        given: "create object of Citizen"
        Citizen citizen = new Citizen("Jason", "Statham", 49L,4L)

        when: "add citizen to DB & after that update citizen"
        citizenDAO.create(citizen);
        citizen.setFirstName("test1");
        citizen.setLastName("test2");
        citizen.setAge(1L);
        citizen.setStreetId(2L);
        citizenDAO.update(citizen);

        then: "check DB"
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM citizen where id="+citizen.getId());
        resultSet.next();
        resultSet.getString("first_name") == "test1";
        resultSet.getString("last_name") == "test2";
        resultSet.getLong("age") == 1L
        resultSet.getLong("street_id") == 2L

        citizenDAO.delete(citizen);
    }

    def "Update crash"() {

        given: "create object of Citizen"
        Citizen citizen = new Citizen("Jason", "Statham", 49L,4L)

        when: "update citizen"
        citizen.setFirstName("test1135");
        citizen.setLastName("test236");
        citizen.setAge(1L);
        citizen.setStreetId(2L);
        citizenDAO.update(citizen);

        then: "check DB"
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM citizen where id="+citizen.getId());
        !resultSet.next();

    }

    def "Delete"() {
        given: "create object of Citizen"
        Citizen citizen = new Citizen("test1", "test2", 49L,4L)

        when: "add citizen to DB & delete"
        citizenDAO.create(citizen);
        citizenDAO.delete(citizen);

        then: "check DB"
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM citizen where id="+citizen.getId());
        !resultSet.next();

    }

    def "Delete crash"() {
        given: "create object of Citizen"
        Citizen citizen = new Citizen("test1", "test2", 49L,4L)

        when: "add citizen to DB & delete"
        citizenDAO.delete(citizen);

        then: "check DB"
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM citizen where id="+citizen.getId());
        !resultSet.next();

    }

    def "Read"() {
        given: "def array list"
        ArrayList list;

        when: "reat DB"
        list = citizenDAO.read();

        then: "check DB"
        !list.isEmpty();

    }

    def "ReadOneById"() {
        given: "create object of Citizen"
        Citizen citizen = new Citizen("test1", "test2", 49L,4L)
        Citizen test;

        when: "add citizen to DB & read"
        citizenDAO.create(citizen);
        test = citizenDAO.readOneById(citizen.getId());

        then: "check DB"
        test.equals(citizen);
        test.hashCode() == citizen.hashCode();

        citizenDAO.delete(citizen)

    }

    def "ReadOneById crash"() {
        given: "create object of Citizen"
        Citizen citizen = new Citizen("test1", "test2", 49L,4L)
        Citizen test;

        when: "add citizen to DB & read"
        citizenDAO.create(citizen);
        test = citizenDAO.readOneById(null);

        then: "check DB"
        null == test;

        citizenDAO.delete(citizen)

    }

    def "ReadOneByEmail"() {

        //не реализовано, т.к. в заюзаной базе нет колонки с мылом
    }
}
