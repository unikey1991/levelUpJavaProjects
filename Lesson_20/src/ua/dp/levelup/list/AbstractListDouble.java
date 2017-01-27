package ua.dp.levelup.list;

import ua.dp.levelup.list.doubleLinkedList.NodeD;

import java.util.Optional;

/**
 * Created by unike on 27.01.2017.
 */
public abstract class AbstractListDouble {

    protected int size = 0;

    public int size(){
        return size;
    }

    public abstract void addNode(NodeD node, int index);

    public abstract void remove(int index);

    public abstract void swap(int nodeA, int nodeB);

    public abstract void addFirst(NodeD node);

    public abstract void addLast(NodeD node);

    public abstract void removeFirst();

    public abstract void removeLast();

    public abstract Optional<NodeD> getFirst();

    public abstract Optional<NodeD> getLast();

    public abstract Optional<NodeD> get(int index);

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();

}
