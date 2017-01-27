package ua.dp.levelup.list.doubleLinkedList;

import ua.dp.levelup.list.AbstractList;
import ua.dp.levelup.list.AbstractListDouble;


import java.util.Optional;

/**
 * Created by unike on 26.01.2017.
 */
public class DoubleLinkedList extends AbstractListDouble {

    private NodeD head = null;
    private NodeD tail = null;

    public NodeD getTail() {
        return tail;
    }

    public NodeD getHead() {

        return head;
    }

    @Override
    public void addNode(NodeD node, int index) {
        if (index < 0 || index > size) return;
        if (index == size) {
            addLast(node);
            return;
        }
        if (null == node) return;
        if (null == head) {
            head = node;
            head.setPrev(null);
            head.setNext(null);
        } else {
            NodeD prev = head;
            NodeD tmp = prev.next();
            for (int currentIndex = 0; currentIndex < size; currentIndex++) {
                if (currentIndex == index - 1) break;
                prev = prev.next();
                tmp = prev.next();
            }
            prev.setNext(node);
            node.setPrev(prev);
            node.setNext(tmp);
            tmp.setPrev(node);
        }
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0 && null == head) return;
        NodeD prev = head;
        NodeD tmp = prev.next();
        for (int currentIndex = 0; currentIndex < size; currentIndex++) {
            if (currentIndex == index - 1) break;
            prev = prev.next();
            tmp = prev.next();
        }
        prev.setNext(tmp.next());
        prev.next().setPrev(prev);
        if (index == size - 1) tail = prev.next();
        tmp.setNext(null);
        tmp.setPrev(null);
        tmp = null;
        size--;
    }

    @Override
    public void swap(int nodeA, int nodeB) {
        if (nodeA < 0|| nodeA >= size || nodeB < 0 || nodeB >= size || size < 2) return;
        NodeD tmpA = head;
        NodeD tmpB = head;
        NodeD prevB;
        NodeD nextB;
        for (int currentIndex = 0; currentIndex< size; currentIndex++){
            if (currentIndex == nodeA) break;
            tmpA = tmpA.next();
        }
        for (int currentIndex = 0; currentIndex< size; currentIndex++){
            if (currentIndex == nodeB) break;
            tmpB = tmpB.next();
        }
        prevB = tmpB.Prev();
        nextB = tmpB.next();

        tmpB.setNext(tmpA.next());
        tmpB.next().setPrev(tmpB);
        tmpB.setPrev(tmpA.Prev());
        tmpB.Prev().setNext(tmpB);

        tmpA.setNext(nextB);
        tmpA.next().setPrev(tmpA);
        tmpA.setPrev(prevB);
        tmpA.Prev().setNext(tmpA);

    }

    @Override
    public void addFirst(NodeD node) {
        if (null == node) return;
        if (null == head) {
            head = node;
            head.setPrev(null);
            head.setNext(null);
        } else {
            node.setNext(head);
            head = node;
            head.setPrev(null);
        }
        if (null == head.next()) tail = head;
        size++;
    }

    @Override
    public void addLast(NodeD node) {
        if (null == node) return;
        if (null == head) {
            head = node;
            head.setPrev(null);
            head.setNext(null);
        } else {
            NodeD tmp = head;
            while (tmp.next() != null) {
                tmp = tmp.next();
            }
            tmp.setNext(node);
            node.setPrev(tmp);
            tail = node;
        }
        if (null == head.next()) tail = head;
        size++;
    }

    @Override
    public void removeFirst() {
        NodeD first = head;
        if (null == first) return;
        if (first.next() != null) {
            head = first.next();
            first.setNext(null);
            first.setPrev(null);
            head.setPrev(null);
        } else {
            head = null;
        }
        if (null == head.next()) tail = head;
        size--;

    }

    @Override
    public void removeLast() {
        NodeD first = head;
        if (null == first) return;
        if (null == first.next()) {
            head = null;
            tail = null;
        } else {
            NodeD tmp = first.next();
            NodeD prev = tmp;
            while (null != tmp.next()) {
                prev = tmp;
                tmp = tmp.next();
            }
            tmp.setPrev(null);
            tmp = null;
            prev.setNext(null);
            tail = prev;
        }
        size--;
    }

    @Override
    public Optional<NodeD> getFirst() {
        return Optional.ofNullable(head);
    }

    @Override
    public Optional<NodeD> getLast() { return Optional.ofNullable(tail); }

    @Override
    public Optional<NodeD> get(int index) {
        if (index < 0 || index >= size) return Optional.empty();
        NodeD result = head;
        for (int currentIndex = 0; currentIndex < size; currentIndex++) {
            if (currentIndex == index) break;
            result = result.next();
        }
        return Optional.of(result);
    }

    @Override
    public boolean isEmpty() {
        return null == head;
    }

    @Override
    public boolean isNotEmpty() {
        return !isEmpty();
    }
}
