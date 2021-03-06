package ua.dp.levelup.list.tree;

import java.util.Comparator;

/**
 * Created by java on 27.01.2017.
 */
public class BinaryTree<T> implements Tree<T> {

    private Node<T> root = null;
    private int size = 0;
    private final Comparator<T> comparator;

    public BinaryTree(final Comparator<T> comparator) {
        this.comparator = comparator;
    }


    private class Node<V> {
        private Node<V> parent = null;
        private Node<V> left = null;
        private Node<V> right = null;
        private final V value;

        public Node(final V value) {
            this.value = value;
        }

        public Node<V> getParent() {
            return parent;
        }

        public void setParent(final Node<V> parent) {
            this.parent = parent;
        }

        public Node<V> getLeft() {
            return left;
        }

        public void setLeft(final Node<V> left) {
            this.left = left;
        }

        public Node<V> getRight() {
            return right;
        }

        public void setRight(final Node<V> right) {
            this.right = right;
        }

        public V getValue() {
            return value;
        }
    }


    @Override
    public void add(T value) {
        if (null == root) {
            root = new Node<T>(value);
        } else {
            add(value, root);
        }
        size++;
    }

    private void add(T val, Node<T> parent) {
        Node<T> node = new Node<T>(val);
        node.setParent(parent);

        if (comparator.compare(val, parent.getValue()) < 0) {
            //left
            if (null == parent.getLeft()) {
                parent.setLeft(node);
            } else {
                add(val, parent.getLeft());
            }
        } else if (comparator.compare(val, parent.getValue()) > 0) {
            //right
            if (null == parent.getRight()) {
                parent.setRight(node);
            } else {
                add(val, parent.getRight());
            }
        }
    }

    @Override
    public void addAll(T[] value) {

    }

    public void remove(T value) {
        Node<T> removed = search(value);
        if (null == removed) return;
        Node<T> removedParent = removed.getParent();

        //- if node that should be removed has two child nodes, remove it and put child with greater value on removed position, then link another child node;
        if (null != removed.getLeft() && null != removed.getRight()) {
            if (removed != root && removedParent.getRight() == removed) {
                removedParent.setRight(removed.getRight());
                removed.getRight().setParent(removedParent);
            } else if (removed != root){
                removedParent.setLeft(removed.getRight());
                removedParent.getLeft().setParent(removedParent);
            }
            removed.getLeft().setParent(findNullChildNode(removed.getRight(), removed.getLeft().getValue())); // установить беспризорнику родителя
            findNullChildNode(removed.getRight(), removed.getLeft().getValue()).setLeft(removed.getLeft()); //найти родителя для оставшегося беспризорника и установить ему родителя :D
            if (removed == root) {
                root = removed.getRight();
                root.setParent(null);
            }
        }

        // - if node that should be removed has only one child, remove it and set parent left/right link to this child;
        else if ((null == removed.getLeft()) ^ (null == removed.getRight())) {
            if (null != removed.getLeft()) {
                if (removed == root) {
                    root = removed.getLeft();
                    root.setParent(null);
                    size--;
                    return;
                }
                removed.getLeft().setParent(removedParent);
                removedParent.setLeft(removed.getLeft());
            } else {
                if (removed == root) {
                    root = removed.getRight();
                    root.setParent(null);
                    size--;
                    return;
                }
                removed.getRight().setParent(removedParent);
                removedParent.setRight(removed.getRight());
            }
        }

        // - if node that should be removed doesn't have any child - just remove it, and set null to parent left/right link;
        else {
            if (removed != root && null != removedParent.getLeft() && comparator.compare(value, removedParent.getLeft().getValue()) == 0)
                removedParent.setLeft(null);
            else if (removed != root && null != removedParent.getRight() && comparator.compare(value, removedParent.getRight().getValue()) == 0)
                removedParent.setRight(null);
            else root = null;
        }
        size--;
    }

    private Node<T> findNullChildNode(Node<T> node, T value) {
        Node<T> tmp = node;
        if (comparator.compare(value, node.getValue()) > 0) {
            if (node.getRight() != null) {
                tmp = node.getRight();
                return findNullChildNode(tmp, value);
            } else return tmp;
        } else {
            if (node.getLeft() != null) {
                tmp = node.getLeft();
                return findNullChildNode(tmp, value);
            } else return tmp;
        }
    }


    /*@Override
    public void remove(T value) {
        Node<T> tmp = search(value);
        if (null == tmp) return;
        Node<T> tmpParent = tmp.getParent();
        if (null != tmp.getLeft() && null != tmp.getRight()) {
            if (comparator.compare(value, tmpParent.getValue()) > 0) {
                Node<T> tmp1 = findNullChildNode(tmp.getLeft(), tmp.getLeft().getValue());
                tmpParent.setRight(tmp.getRight());
                tmp.getRight().setParent(tmpParent);
                if (tmp1 != tmp.getRight()) {
                    if (comparator.compare(tmp.getRight().getValue(), tmp1.getValue()) > 0)
                        tmp1.setRight(tmp.getRight());
                    else tmp1.setLeft(tmp.getRight());
                } else {
                    tmpParent.getRight().setLeft(tmp.getLeft());
                    tmpParent.getRight().getLeft().setParent(tmpParent.getRight());

                }
                tmp.getRight().setParent(tmp1);
            } else {
                Node<T> tmp1 = findNullChildNode(tmp.getRight(), tmp.getRight().getValue());
                tmpParent.setLeft(tmp.getRight());// установить левым наследником родителя правого наследника тмп
                tmp.getRight().setParent(tmpParent); //правому наследнику тмп установить родителя
                if (tmp1 != tmp.getLeft()) {
                    if (comparator.compare(tmp.getLeft().getValue(), tmp1.getValue()) > 0) tmp1.setRight(tmp.getLeft());
                    else tmp1.setLeft(tmp.getLeft());
                } else {
                    tmpParent.getLeft().setLeft(tmp.getLeft());
                    tmpParent.getLeft().getLeft().setParent(tmpParent.getRight());

                }
                tmp.getLeft().setParent(tmp1);
            }
        } else if ((null == tmp.getLeft()) ^ (null == tmp.getRight())) {
            if (null != tmp.getLeft()) {
                tmp.getLeft().setParent(tmpParent);
                if (comparator.compare(tmp.getLeft().getValue(), tmp.getParent().getValue()) > 0)
                    tmpParent.setRight(tmp.getLeft());
                else tmpParent.setLeft(tmp.getLeft());
            } else {
                tmp.getRight().setParent(tmpParent);
                if (comparator.compare(tmp.getRight().getValue(), tmp.getParent().getValue()) > 0)
                    tmpParent.setRight(tmp.getRight());
                else tmpParent.setLeft(tmp.getRight());
            }

        } else {
            if (null != tmpParent.getLeft() && comparator.compare(value, tmpParent.getLeft().getValue()) == 0)
                tmpParent.setLeft(null);
            else if (null != tmpParent.getRight() && comparator.compare(value, tmpParent.getRight().getValue()) == 0)
                tmpParent.setRight(null);
        }
        size--;
    }*/

    @Override
    public void print() {
        if (null == root) return;
        printChild(root);
    }


    @Override
    public Node<T> search(T value) {
        return searcRecurcy(value, root);
    }

    public Node<T> searcRecurcy(T value, Node<T> result) {
        if (null == result || comparator.compare(value, result.getValue()) == 0) return result;
        else if (comparator.compare(value, result.getValue()) == -1) return searcRecurcy(value, result.getLeft());
        else return searcRecurcy(value, result.getRight());
    }


    private void printChild(Node<T> parent) {
        if (parent.getLeft() != null) {
            printChild(parent.getLeft());
        }
        System.out.println(parent.getValue());
        if (parent.getRight() != null) {
            printChild(parent.getRight());
        }
    }

    public int getSize() {
        return size;
    }
}
