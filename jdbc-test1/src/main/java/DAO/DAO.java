package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by unike on 23.03.2017.
 */
public interface DAO<T> {

    void create(T T) throws SQLException;

    void update(T T) throws SQLException;

    void delete(T T) throws SQLException;

    ArrayList<T> read() throws SQLException;

    T readOneById(long id) throws SQLException;

    T readOneByEmail(String email);
}
