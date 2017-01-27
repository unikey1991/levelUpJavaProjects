package ua.dp.levelup.list.singleLinkedList;

import ua.dp.levelup.list.AbstractList;

import java.util.Optional;

/**
 * Created by java on 24.01.2017.
 */
public class SingleLinkedList extends AbstractList {

    private Node root = null;



    @Override
    public void addNode(Node node, int index) {
        if (index < 0 || index > size) return;
        if (index == size) {
            addLast(node);
            return;
        }
        if (null == node) return;
        if (null == root) {
            root = node;
        } else {
            Node prev = root;
            Node tmp = prev.next();
            for (int currentIndex = 0; currentIndex< size; currentIndex++){
                if (currentIndex == index-1) break;
                prev = prev.next();
                tmp = prev.next();
            }
            prev.setNext(node);
            node.setNext(tmp);
        }
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0 && null == root) return;
        Node prev = root;
        Node tmp = prev.next();
        for (int currentIndex = 0; currentIndex< size; currentIndex++){
            if (currentIndex == index-1) break;
            prev = prev.next();
            tmp = prev.next();
        }
        prev.setNext(tmp.next());
        tmp.setNext(null);
        tmp = null;
        size--;
    }

    @Override
    public void swap(int nodeA, int nodeB) {
        if (nodeA < 0|| nodeA >= size || nodeB < 0 || nodeB >= size || size < 2) return;
        Node prevA = root;
        Node tmpA = prevA.next();
        Node prevB = root;
        Node tmpB = prevB.next();
        Node nextB;
        for (int currentIndex = 0; currentIndex< size; currentIndex++){
            if (currentIndex == nodeA-1) break;
            prevA = prevA.next();
            tmpA = prevA.next();
        }
        for (int currentIndex = 0; currentIndex< size; currentIndex++){
            if (currentIndex == nodeB-1) break;
            prevB = prevB.next();
            tmpB = prevB.next();
        }
        nextB = tmpB.next();
        prevA.setNext(tmpB);
        prevB.setNext(tmpA);
        tmpB.setNext(tmpA.next());
        tmpA.setNext(nextB);
    }

    @Override
    public void addFirst(Node node) {
        if (null == node) return;
        if (null == root) {
            root = node;
        } else {
            node.setNext(root);
            root = node;
        }
        size++;
    }

    @Override
    public void addLast(Node node) {
        if (null == node) return;
        if (null == root) {
            root = node;
        } else {
            Node tmp = root;
            while (tmp.next() != null) {
                tmp = tmp.next();
            }
            tmp.setNext(node);
        }
        size++;
    }

    @Override
    public void removeFirst() {
        Node first = root;
        if (null == first) return;
        if (first.next() != null) {
            root = first.next();
            first.setNext(null);
        } else {
            root = null;
        }
        size--;

    }

    @Override
    public void removeLast() {
        Node first = root;
        if (null == first) return;
        if (null == first.next()) {
            root = null;
        } else {
            Node tmp = first.next();
            Node prev = tmp;
            while (null != tmp.next()) {
                prev = tmp;
                tmp = tmp.next();
            }
            prev.setNext(null);
        }
        size--;
    }

    @Override
    public Optional<Node> getFirst() {
        return Optional.ofNullable(root);
    }

    @Override
    public Optional<Node> getLast() {
        Node tmp = root;
        while (tmp.next() != null) {
            tmp = tmp.next();
        }
        return Optional.of(tmp);
    }

    @Override
    public Optional<Node> get(int index) {
        if (index < 0 || index >= size) return Optional.empty();
        Node result = root;
        for (int currentIndex = 0; currentIndex< size; currentIndex++){
            if (currentIndex == index) break;
            result = result.next();
        }
        return Optional.of(result);
    }

    @Override
    public boolean isEmpty() {
        return null == root;
    }

    @Override
    public boolean isNotEmpty() {
        return !isEmpty();
    }
}
