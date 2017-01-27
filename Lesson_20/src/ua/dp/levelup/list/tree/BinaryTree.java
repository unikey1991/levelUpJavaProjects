package ua.dp.levelup.list.tree;

import java.util.Comparator;

/**
 * Created by java on 27.01.2017.
 */
public class BinaryTree<T> implements Tree<T> {


    private class Node<V> {
        private Node<V> parent;
        private Node<V> left;
        private Node<V> right;
        private final V value;

        public Node(V value) {
            this.value = value;
        }

        public Node<V> getParent() {
            return parent;
        }

        public void setParent(Node<V> parent) {
            this.parent = parent;
        }

        public Node<V> getLeft() {
            return left;
        }

        public void setLeft(Node<V> left) {
            left.setParent(this);
            this.left = left;
        }

        public Node<V> getRight() {
            right.setParent(this);
            return right;
        }

        public void setRight(Node<V> right) {
            this.right = right;
        }

        public V getValue() {
            return value;
        }
    }

    private Node<T> root;
    private int size = 0;
    private final Comparator<T> comparator;

    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }


    @Override
    public void add(T value) {
        if (null == root) {
            root = new Node<>(value);
        } else {
            add(value, root);
        }
    }

    private void add(T val, Node<T> parent) {
        if (comparator.compare(val, parent.getValue()) < 0){
            //left
            if (parent.getLeft() == null){
                parent.setLeft(new Node<>(val));
            } else {
                add(val, parent.getLeft());
            }
        } else if (comparator.compare(val, root.getValue()) > 0){
            //right
            if (parent.getRight() == null){
                parent.setRight(new Node<>(val));
            } else {
                add(val, parent.getRight());
            }
        }
    }

    @Override
    public void addAll(T[] value) {

    }

    @Override
    public void remove(T value) {

    }

    @Override
    public void print() {
        if (null == root) return;
        printChild(root);
    }

    private void printChild(Node<T> parent) {
        if (parent.getLeft() != null){
            printChild(parent.getLeft());
        }
        System.out.println(parent.getValue());
        if (parent.getRight() != null){
            printChild(parent.getRight());
        }
    }
}
