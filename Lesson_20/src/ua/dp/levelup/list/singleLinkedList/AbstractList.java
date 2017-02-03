package ua.dp.levelup.list.singleLinkedList;

import ua.dp.levelup.list.doubleLinkedList.NodeD;
import ua.dp.levelup.list.singleLinkedList.Node;

import java.util.Optional;

/**
 * Created by java on 24.01.2017.
 */
public abstract class AbstractList<N> {

    protected int size = 0;

    public int size(){
        return size;
    }

    public abstract void addNode(N node, int index);

    public abstract void remove(int index);

    public abstract void swap(int nodeA, int nodeB);

    public abstract void addFirst(N node);

    public abstract void addLast(N node);

    public abstract void removeFirst();

    public abstract void removeLast();

    public abstract Optional<N> getFirst();

    public abstract Optional<N> getLast();

    public abstract Optional<N> get(int index);

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();


}
