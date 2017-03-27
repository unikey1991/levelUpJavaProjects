package DAO.impl;

import DAO.DAO;
import entity.Citizen;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by unike on 23.03.2017.
 */
public class CitizenDAOImpl<T extends Citizen> implements DAO<Citizen> {

    Connection connection;

    public CitizenDAOImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(Citizen t) throws SQLException {
        if (null == t) return;
        PreparedStatement preparedStatement = connection.prepareStatement
                ("INSERT INTO CITIZEN (first_name, last_name, age, street_id) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, t.getFirstName());
        preparedStatement.setString(2, t.getLastName());
        preparedStatement.setLong(3, t.getAge());
        preparedStatement.setLong(4, t.getStreetId());
        preparedStatement.execute();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

        if (generatedKeys.next()) {
            Long id = generatedKeys.getLong("GENERATED_KEY");
            t.setId(id);
        }
    }

    @Override
    public void update(Citizen t) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement
                ("UPDATE CITIZEN SET first_name = ?, last_name= ?, age = ?, street_id = ? WHERE id=?");
        preparedStatement.setString(1, t.getFirstName());
        preparedStatement.setString(2, t.getLastName());
        preparedStatement.setLong(3, t.getAge());
        preparedStatement.setLong(4, t.getStreetId());
        preparedStatement.setLong(5, t.getId());
        preparedStatement.execute();
    }

    @Override
    public void delete(Citizen t) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement
                ("DELETE FROM citizen WHERE id = ?");
        preparedStatement.setLong(1, t.getId());
        preparedStatement.execute();
    }

    @Override
    public ArrayList<Citizen> read() throws SQLException {
        ArrayList list = new ArrayList();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM citizen");
        while (resultSet.next()) {
            list.add(parseCitizen(resultSet));
        }
        return list;
    }

    @Override
    public Citizen readOneById(Long id) throws SQLException {
        Citizen citizen = null;
        if (null == id) {
            System.out.println("Citizen with id " + id + " is not exist");
            return citizen;
        }
        PreparedStatement preparedStatement = connection.prepareStatement
                ("SELECT * FROM citizen WHERE id = ?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            citizen = parseCitizen(resultSet);
        } else System.out.println("Citizen with id " + id + " is not exist");
        return citizen;
    }

    @Override
    public Citizen readOneByEmail(String email) throws SQLException {
        Citizen citizen = null;
        if (!email.contains("@")) {
            System.out.println("Wrong email format");
            return citizen;
        }
        PreparedStatement preparedStatement = connection.prepareStatement
                ("SELECT * FROM citizen WHERE email = ? ");
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            citizen = parseCitizen(resultSet);
        } else System.out.println("Citizen with email " + email + " is not exist");

        return citizen;
    }

    private Citizen parseCitizen(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        Long age = resultSet.getLong("age");
        Long streetid = resultSet.getLong("street_id");
        return new Citizen(id, firstName, lastName, age, streetid);
    }


}
