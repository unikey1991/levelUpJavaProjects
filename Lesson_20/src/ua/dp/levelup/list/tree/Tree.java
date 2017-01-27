package ua.dp.levelup.list.tree;

/**
 * Created by java on 27.01.2017.
 */
public interface Tree<T> {

    void add(T value);
    void addAll(T[] value);
    void remove(T value);
    void print();
}
