package ua.dp.levelup.list.doubleLinkedList;



import ua.dp.levelup.list.singleLinkedList.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by unike on 26.01.2017.
 */
public class DoubleLinkedList <T> extends AbstractListDouble<NodeD<T>> implements Iterable<NodeD<T>> {

    private NodeD<T> head = null;
    private NodeD<T> tail = null;

    public NodeD<T> getTail() {
        return tail;
    }

    public NodeD<T> getHead() {

        return head;
    }

    @Override
    public void addNode(NodeD<T> node, int index) {
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
            NodeD<T>  prev = head;
            NodeD<T>  tmp = prev.next();
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
        NodeD<T>  prev = head;
        NodeD<T>  tmp = prev.next();
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
        if (nodeA < 0|| nodeA >= size || nodeB < 0 || nodeB >= size || size < 2 || nodeA == nodeB) return;
        NodeD<T>  tmpA = get(nodeA).get();
        NodeD<T>  tmpB = get(nodeB).get();
        NodeD<T>  prevB = tmpB.Prev();
        NodeD<T>  nextB = tmpB.next();

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
    public void addFirst(NodeD<T> node) {
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
    public void addLast(NodeD<T> node) {
        if (null == node) return;
        if (null == head) {
            head = node;
            head.setPrev(null);
            head.setNext(null);
        } else {
            NodeD<T> tmp = head;
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
        NodeD<T> first = head;
        if (null == first) return;
        if (first.next() != null) {
            head = first.next();
            first.setNext(null);
            first.setPrev(null);
            head.setPrev(null);
        } else {
            head = null;
        }
        if (null == first.next()) tail = head;
        size--;

    }

    @Override
    public void removeLast() {
        NodeD<T> first = head;
        if (null == first) return;
        if (null == first.next()) {
            head = null;
            tail = null;
        } else {
            NodeD<T> tmp = first.next();
            NodeD<T> prev = tmp;
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
    public Optional<NodeD<T>> getFirst() {
        return Optional.ofNullable(head);
    }

    @Override
    public Optional<NodeD<T>> getLast() { return Optional.ofNullable(tail); }

    @Override
    public Optional<NodeD<T>> get(int index) {
        if (index < 0 || index >= size) return Optional.empty();

        /*NodeD<T> result = head;
        for (int currentIndex = 0; currentIndex < size; currentIndex++) {
            if (currentIndex == index) break;
            result = result.next();
        }*/

        NodeD<T> res = null;
        Iterator<NodeD<T>> iterator = iterator();
        int currentIndex = 0;
        while (iterator.hasNext() && currentIndex <= index){
            res = iterator.next();
            currentIndex++;
        }
        return Optional.ofNullable(res);
    }

    @Override
    public boolean isEmpty() {
        return null == head;
    }

    @Override
    public boolean isNotEmpty() {
        return !isEmpty();
    }

    @Override
    public Iterator<NodeD<T>> iterator() {
        return new Iterator<NodeD<T>>() {

            private NodeD<T> cursor = head;

            @Override
            public boolean hasNext() {
                return null != cursor;
            }

            @Override
            public NodeD<T> next() {
                if (!hasNext()) throw new NoSuchElementException();
                NodeD<T> tmp = cursor;
                cursor = tmp.next();
                return tmp;
            }
        };
    }

    public Iterator<NodeD<T>> descendingIterator(){
        return new Iterator<NodeD<T>>() {

            private NodeD<T> cursor = tail;

            @Override
            public boolean hasNext() {
                return null != cursor;
            }

            @Override
            public NodeD<T> next() {
                if (!hasNext()) throw new NoSuchElementException();
                NodeD<T> tmp = cursor;
                cursor = tmp.Prev();
                return tmp;
            }
        };
    }

    public Optional<NodeD<T>> descendingGet(int index) {
        if (index < 0 || index >= size) return Optional.empty();

        NodeD<T> res = null;
        Iterator<NodeD<T>> descendingIterator = descendingIterator();
        int currentIndex = size-1;
        while (descendingIterator.hasNext() && currentIndex >= index){
            res = descendingIterator.next();
            currentIndex--;
        }
        return Optional.ofNullable(res);
    }
}
