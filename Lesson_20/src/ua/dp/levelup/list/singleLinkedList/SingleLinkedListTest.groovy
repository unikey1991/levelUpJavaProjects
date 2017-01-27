package ua.dp.levelup.list.singleLinkedList

import spock.lang.Specification


/**
 * Created by java on 24.01.2017.
 */
class SingleLinkedListTest extends Specification {
    def "add first node to empty"() {
        SingleLinkedList list = new SingleLinkedList();

        when: "add node element"
        list.addFirst(new Node(1));

        then: "check size"
        list.size() == 1;
        list.getFirst().isPresent();
        list.getFirst().get().value == 1;

    }

    def "add null node to empty"() {
        SingleLinkedList list = new SingleLinkedList();

        when: "add node element"
        list.addFirst(null);

        then: "check size"
        list.size() == 0;
        !list.getFirst().isPresent();

    }

    def "add first node to list with one element"() {

        SingleLinkedList list = new SingleLinkedList();

        list.addFirst(new Node(1))


        when:"add one more node element"
        list.addFirst(new Node(5))

        then:"check size"
        list.size() == 2;
        list.getFirst().isPresent();
        list.getFirst().get().value == 5;
    }

    def "addFirst null node to list with one element"() {

        SingleLinkedList list = new SingleLinkedList();

        list.addFirst(new Node(1))


        when:"add one more node element"
        list.addFirst(null)

        then:"check size"
        list.size() == 1;
        list.getFirst().isPresent();
        list.getFirst().get().value == 1;
    }

    def "add node to index 3 to list with 5 elements"() {

        SingleLinkedList list = new SingleLinkedList();

        list.addLast(new Node(0))
        list.addLast(new Node(1))
        list.addLast(new Node(2))
        list.addLast(new Node(3))
        list.addLast(new Node(4))


        when:"add one more node element"
        list.addNode(new Node(33),3)


        then:"check size & nodes with index 2, 3, 4"
        list.size() == 6;
        list.get(2).get().next == list.get(3).get();
        list.get(3).get().value == 33;
        list.get(3).get().next == list.get(4).get();
        list.get(4).get().value == 3;
        list.get(4).get().next == list.get(5).get();

    }

    def "remove node at index 3 from list with 5 elements"() {

        SingleLinkedList list = new SingleLinkedList();

        list.addLast(new Node(0))
        list.addLast(new Node(1))
        list.addLast(new Node(2))
        list.addLast(new Node(3))
        list.addLast(new Node(4))


        when:"remove one more node element"
        list.remove(3)


        then:"check size & nodes with index 2, 3, 4"
        list.size() == 4;
        list.get(2).get().next == list.get(3).get();
        list.get(3).get().value == 4;
        !list.get(4).isPresent();
    }

    def "swap nodes at index 1 & 4 from list with 7 elements"() {

        SingleLinkedList list = new SingleLinkedList();

        list.addLast(new Node(0));
        list.addLast(new Node(1));
        list.addLast(new Node(2));
        list.addLast(new Node(3));
        list.addLast(new Node(4));
        list.addLast(new Node(5));
        list.addLast(new Node(6));


        when:"swap nodes"
        list.swap(1,4)


        then:"check size & nodes"
        list.size() == 7;
        list.get(0).get().next == list.get(1).get();
        list.get(1).get().value == 4;
        list.get(1).get().next == list.get(2).get();

        list.get(3).get().next == list.get(4).get();
        list.get(4).get().value == 1;
        list.get(4).get().next == list.get(5).get();
    }
}
