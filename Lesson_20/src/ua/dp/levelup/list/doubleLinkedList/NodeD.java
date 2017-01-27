package ua.dp.levelup.list.doubleLinkedList;

/**
 * Created by unike on 27.01.2017.
 */
public class NodeD {

    private NodeD prev = null;
    private NodeD next = null;
    private Object value;


    public NodeD(Object value) {
        this.value = value;
    }


    public NodeD next() {
        return next;
    }

    public void setNext(NodeD next) {
        this.next = next;
    }

    public NodeD Prev() {
        return prev;
    }

    public void setPrev(NodeD prev) {
        this.prev = prev;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
