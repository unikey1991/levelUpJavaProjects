package ua.dp.levelup.list.doubleLinkedList;

/**
 * Created by unike on 27.01.2017.
 */
public class NodeD<V> {

    private NodeD<V> next = null;
    private NodeD<V> prev = null;
    private V value;


    public NodeD(V value) {
        this.value = value;
    }

//
    public NodeD<V> next() {
        return next;
    }

    public void setNext(NodeD<V> next) {
        this.next = next;
    }

    public NodeD<V> Prev() {
        return prev;
    }

    public void setPrev(NodeD<V> prev) {
        this.prev = prev;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
