package ua.dp.levelup.list.tree

import spock.lang.Specification

/**
 * Created by unike on 29.01.2017.
 */
class BinaryTreeTest extends Specification {

    def "add first element to empty"() {
        BinaryTree<Integer> tree = new BinaryTree<>(new Comparator<Integer>() {
            @Override
            int compare(Integer o1, Integer o2) {
                if (o1 > o2) return 1;
                if (o1 == o2) return 0;
                if (o1 < o2) return -1;
            }
        });

        when: "add element"
        tree.add(0);

        then: "check size"
        tree.getSize() == 1;
        tree.root.value == 0;
    }

    def "add element to tree with 2 elements"() {
        BinaryTree<Integer> tree = new BinaryTree<>(new Comparator<Integer>() {
            @Override
            int compare(Integer o1, Integer o2) {
                if (o1 > o2) return 1;
                if (o1 == o2) return 0;
                if (o1 < o2) return -1;
            }
        });

        when: "add node element"
        tree.add(0);
        tree.add(1);
        tree.add(2);

        then: "check size"
        tree.getSize() == 3;
    }

    def "add elements to tree and search"() {
        BinaryTree<Integer> tree = new BinaryTree<>(new Comparator<Integer>() {
            @Override
            int compare(Integer o1, Integer o2) {
                if (o1 > o2) return 1;
                if (o1 == o2) return 0;
                if (o1 < o2) return -1;
            }
        });

        when: "add node element"
        tree.add(0);
        tree.add(1);
        tree.add(2);
        tree.add(4);
        tree.add(5);


        then: "search"
        tree.search(500) == null;
        tree.search(4).value == 4
    }

    def "remove non-existent element & check size "() {
        BinaryTree<Integer> tree = new BinaryTree<>(new Comparator<Integer>() {
            @Override
            int compare(Integer o1, Integer o2) {
                if (o1 > o2) return 1;
                if (o1 == o2) return 0;
                if (o1 < o2) return -1;
            }
        });

        when: "add element & remove"
        tree.add(0);
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);

        tree.remove(5456)


        then: "check size"
        tree.size == 5;
    }

    def "add elements & check structure"() {
        BinaryTree<Integer> tree = new BinaryTree<>(new Comparator<Integer>() {
            @Override
            int compare(Integer o1, Integer o2) {
                if (o1 > o2) return 1;
                if (o1 == o2) return 0;
                if (o1 < o2) return -1;
            }
        });

        when: "add elements"
        tree.add(26); //root

        tree.add(17); //left
        tree.add(32); //right

        tree.add(22); //left-right
        tree.add(11); //left-left

        tree.add(45); //right-right
        tree.add(28); //right-left

        tree.add(19); //left-right-left
        tree.add(24); //left-right-right


        then: "check structure"
        tree.root.value == 26;

        tree.root.getLeft().value == 17;
        tree.root.getRight().value == 32;

        tree.root.getLeft().getRight().value == 22;
        tree.root.getLeft().getLeft().value == 11;

        tree.root.getRight().getRight().value == 45;
        tree.root.getRight().getLeft().value == 28;

        tree.root.getLeft().getRight().getLeft().value == 19;
        tree.root.getLeft().getRight().getRight().value == 24;
    }

    def "add elements & check structure after remove element without left/right child"() {
        BinaryTree<Integer> tree = new BinaryTree<>(new Comparator<Integer>() {
            @Override
            int compare(Integer o1, Integer o2) {
                if (o1 > o2) return 1;
                if (o1 == o2) return 0;
                if (o1 < o2) return -1;
            }
        });

        when: "add elements"
        tree.add(50); //root

        tree.add(40); //left

        tree.add(60); //right

        tree.add(45); //left-right

        tree.add(35); //left-left

        tree.add(65); //right-right

        tree.add(55); //right-left

        tree.remove(55)


        then: "check structure & size"
        tree.size == 6;
        tree.root.value == 50;

        tree.root.getLeft().value == 40;
        tree.root.getRight().value == 60;

        tree.root.getLeft().getRight().value == 45;
        tree.root.getLeft().getLeft().value == 35;

        tree.root.getRight().getRight().value == 65;
        tree.root.getRight().getLeft() == null;
    }

    def "add elements & check structure after remove element with left&right childs"() {
        BinaryTree<Integer> tree = new BinaryTree<>(new Comparator<Integer>() {
            @Override
            int compare(Integer o1, Integer o2) {
                if (o1 > o2) return 1;
                if (o1 == o2) return 0;
                if (o1 < o2) return -1;
            }
        });

        when: "add elements"
        tree.add(26); //root

        tree.add(17); //left
        tree.add(32); //right

        tree.add(22); //left-right
        tree.add(11); //left-left

        tree.add(45); //right-right
        tree.add(28); //right-left

        tree.add(19); //left-right-left
        tree.add(24); //left-right-right

        tree.remove(32)


        then: "check structure & size"
        tree.size == 8;
        tree.root.value == 26;

        tree.root.getLeft().value == 17;
        tree.root.getRight().value == 45;

        tree.root.getLeft().getRight().value == 22;
        tree.root.getLeft().getRight().getLeft().value == 19;
        tree.root.getLeft().getLeft().value == 11;

        tree.root.getRight().getRight() == null;
        tree.root.getRight().getLeft().value == 28;
    }

    def "add elements & check structure after remove of a non-existent element"() {
        BinaryTree<Integer> tree = new BinaryTree<>(new Comparator<Integer>() {
            @Override
            int compare(Integer o1, Integer o2) {
                if (o1 > o2) return 1;
                if (o1 == o2) return 0;
                if (o1 < o2) return -1;
            }
        });

        when: "add elements"
        tree.add(50); //root

        tree.add(40); //left

        tree.add(60); //right

        tree.add(45); //left-right

        tree.add(35); //left-left

        tree.add(65); //right-right

        tree.add(55); //right-left

        tree.remove(600)
        tree.remove(6000)


        then: "check structure & size"
        tree.root.value == 50;

        tree.root.getLeft().value == 40;
        tree.root.getRight().value == 60;

        tree.root.getLeft().getRight().value == 45;
        tree.root.getLeft().getLeft().value == 35;

        tree.root.getRight().getRight().value == 65;
        tree.root.getRight().getLeft().value == 55;
    }

    def "aaaaaa"() {
        BinaryTree<Integer> tree = new BinaryTree<>(new Comparator<Integer>() {
            @Override
            int compare(Integer o1, Integer o2) {
                if (o1 > o2) return 1;
                if (o1 == o2) return 0;
                if (o1 < o2) return -1;
            }
        });

        when: "add elements"
        tree.add(26); //root

        tree.add(17); //left
        tree.add(32); //right

        tree.add(22); //left-right
        tree.add(11); //left-left

        tree.add(45); //right-right
        tree.add(28); //right-left

        tree.add(19); //left-right-left
        tree.add(24); //left-right-right

        tree.remove(17)


        then: "check structure"
        tree.root.value == 26;

        tree.root.getLeft().value == 22;
        tree.root.getRight().value == 32;

        tree.root.getLeft().getRight().value == 24;
        tree.root.getLeft().getLeft().value == 19;

        tree.root.getRight().getRight().value == 45;
        tree.root.getRight().getLeft().value == 28;

        tree.root.getLeft().getLeft().getLeft().value == 11;
    }

    def "add elements and remove root node than check structure"() {
        BinaryTree<Integer> tree = new BinaryTree<>(new Comparator<Integer>() {
            @Override
            int compare(Integer o1, Integer o2) {
                if (o1 > o2) return 1;
                if (o1 == o2) return 0;
                if (o1 < o2) return -1;
            }
        });

        when: "add elements & remove root node"
        tree.add(26); //root

        tree.add(17); //left
        tree.add(32); //right

        tree.add(22); //left-right
        tree.add(11); //left-left

        tree.add(45); //right-right
        tree.add(28); //right-left

        tree.add(19); //left-right-left
        tree.add(24); //left-right-right

        tree.remove(26)


        then: "check structure"
        tree.root.value == 32;

        //left
        tree.root.getLeft().value == 28;
        tree.root.getLeft().getLeft().value == 17;
        tree.root.getLeft().getLeft().getLeft().value == 11;
        tree.root.getLeft().getLeft().getRight().getValue() == 22;
        tree.root.getLeft().getLeft().getRight().getLeft().getValue() == 19;
        tree.root.getLeft().getLeft().getRight().getRight().getValue() == 24;


        //right
        tree.root.getRight().value == 45;

    }
}
