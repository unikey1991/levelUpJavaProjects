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
        PreparedStatement preparedStatement = connection.prepareStatement
                ("INSERT INTO CITIZEN (id, first_name, last_name, age, street_id) VALUES(?,?,?,?,?)");
        preparedStatement.setLong(1, t.getId());
        preparedStatement.setString(2, t.getFirstName());
        preparedStatement.setString(3, t.getLastName());
        preparedStatement.setLong(4, t.getAge());
        preparedStatement.setLong(5, t.getStreetId());
        preparedStatement.execute();
    }

    @Override
    public void update(Citizen t) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement
                ("UPDATE CITIZEN SET (first_name, last_name, age, street_id) VALUES(?,?,?,?) WHERE id="+t.getId());
        preparedStatement.setString(1, t.getFirstName());
        preparedStatement.setString(2, t.getLastName());
        preparedStatement.setLong(3, t.getAge());
        preparedStatement.setLong(4, t.getStreetId());
        preparedStatement.execute();

    }

    @Override
    public void delete(Citizen t) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeQuery("DELETE FROM citizen WHERE id="+t.getId());
    }

    @Override
    public ArrayList<Citizen> read() throws SQLException {
        ArrayList list = new ArrayList();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM citizen");
        while (resultSet.next()) {
            Long id = resultSet.getLong("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            Long age = resultSet.getLong("age");
            Long streetid = resultSet.getLong("street_id");
            list.add(new Citizen(id,firstName,lastName,age,streetid));
        }
        return list;
    }

    @Override
    public Citizen readOneById(long id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM citizen WHERE id ="+id);

        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        Long age = resultSet.getLong("age");
        Long streetid = resultSet.getLong("street_id");
        return new Citizen(id,firstName,lastName,age,streetid);
    }

    @Override
    public Citizen readOneByEmail(String email) {
        return null;
    }


}
