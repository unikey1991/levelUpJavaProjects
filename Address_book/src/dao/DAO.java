package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public interface DAO<T>
{
    void create(T t);

    ArrayList<T> read();

    void update(T t);

    void delete(T t);
}
