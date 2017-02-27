package dao.impl;

import java.util.ArrayList;

/**
 * Created by unike on 27.02.2017.
 */
public interface DAO<T> {

    void create(T t);

    ArrayList<T> read();

    void update(T t);

}
