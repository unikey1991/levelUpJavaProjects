package ua.dp.levelup.list.doubleLinkedList

import spock.lang.Specification

/**
 * Created by unike on 27.01.2017.
 */
class DoubleLinkedListTest extends Specification {


    def "add first node to empty"() {
        DoubleLinkedList list = new DoubleLinkedList();

        when: "add node element"
        list.addFirst(new NodeD(1));

        then: "check size"
        list.size() == 1;
        list.getFirst().isPresent();
        list.getFirst().get().value == 1;

    }

    def "add null node to empty"() {
        DoubleLinkedList list = new DoubleLinkedList();

        when: "add node element"
        list.addFirst(null);

        then: "check size"
        list.size() == 0;
        !list.getFirst().isPresent();

    }

    def "add first node to list with one element"() {

        DoubleLinkedList list = new DoubleLinkedList();

        list.addFirst(new NodeD(1))


        when: "add one more node element"
        list.addFirst(new NodeD(5))

        then: "check size"
        list.size() == 2;
        list.getFirst().isPresent();
        list.getFirst().get().value == 5;
    }

    def "addFirst null node to list with one element"() {

        DoubleLinkedList list = new DoubleLinkedList();

        list.addFirst(new NodeD(1))


        when: "add one more node element"
        list.addFirst(null)

        then: "check size"
        list.size() == 1;
        list.getFirst().isPresent();
        list.getFirst().get().value == 1;
    }

    def "add node to index 3 to list with 5 elements"() {

        DoubleLinkedList list = new DoubleLinkedList();

        list.addLast(new NodeD(0))
        list.addLast(new NodeD(1))
        list.addLast(new NodeD(2))
        list.addLast(new NodeD(3))
        list.addLast(new NodeD(4))


        when: "add one more node element"
        list.addNode(new NodeD(33), 3)


        then: "check size & nodes with index 2, 3, 4"
        list.size() == 6;
        list.get(2).get().prev == list.get(1).get();
        list.get(2).get().next == list.get(3).get();

        list.get(3).get().value == 33;
        list.get(3).get().prev == list.get(2).get();
        list.get(3).get().next == list.get(4).get();

        list.get(4).get().value == 3;
        list.get(4).get().prev == list.get(3).get();
        list.get(4).get().next == list.get(5).get();

    }

    def "remove node at index 3 from list with 5 elements"() {

        DoubleLinkedList list = new DoubleLinkedList();

        list.addLast(new NodeD(0))
        list.addLast(new NodeD(1))
        list.addLast(new NodeD(2))
        list.addLast(new NodeD(3))
        list.addLast(new NodeD(4))


        when: "remove one more node element"
        list.remove(3)


        then: "check size & nodes with index 2, 3, 4"
        list.size() == 4;
        list.get(2).get().next == list.get(3).get();
        list.get(3).get().value == 4;
        list.get(3).get().prev == list.get(2).get();
        !list.get(4).isPresent();
    }

    def "swap nodes at index 1 & 4 from list with 7 elements"() {

        DoubleLinkedList list = new DoubleLinkedList();

        list.addLast(new NodeD(0));
        list.addLast(new NodeD(1));
        list.addLast(new NodeD(2));
        list.addLast(new NodeD(3));
        list.addLast(new NodeD(4));
        list.addLast(new NodeD(5));
        list.addLast(new NodeD(6));


        when: "swap nodes"
        list.swap(1, 4)


        then: "check size & nodes"
        list.size() == 7;
        list.get(0).get().prev == null;
        list.get(0).get().next == list.get(1).get();

        list.get(1).get().prev == list.get(0).get();
        list.get(1).get().next == list.get(2).get();

        list.get(3).get().prev == list.get(2).get();
        list.get(3).get().next == list.get(4).get();

        list.get(4).get().prev == list.get(3).get();
        list.get(4).get().next == list.get(5).get();

        list.get(0).get().value == 0;
        list.get(1).get().value == 4;
        list.get(2).get().value == 2;
        list.get(3).get().value == 3;
        list.get(4).get().value == 1;
        list.get(5).get().value == 5;
        list.get(6).get().value == 6;
    }


    def "get nodes with descendingGet & check"() {

        DoubleLinkedList list = new DoubleLinkedList();

        when: "add one more node element"
        list.addLast(new NodeD(0))
        list.addLast(new NodeD(1))
        list.addLast(new NodeD(2))
        list.addLast(new NodeD(3))
        list.addLast(new NodeD(4))


        then: "get & check"
        list.descendingGet(4).get() == list.tail;
        list.descendingGet(3).get() == list.tail.prev;
        list.descendingGet(2).get() == list.head.next.next;
        list.descendingGet(1).get() == list.head.next;
        list.descendingGet(0).get() == list.head;
    }

    def "get nodes with Get & check"() {

        DoubleLinkedList list = new DoubleLinkedList();

        when: "add one more node element"
        list.addLast(new NodeD(0))
        list.addLast(new NodeD(1))
        list.addLast(new NodeD(2))
        list.addLast(new NodeD(3))
        list.addLast(new NodeD(4))


        then: "get & check"
        list.get(4).get() == list.tail;
        list.get(3).get() == list.tail.prev;
        list.get(2).get() == list.head.next.next;
        list.get(1).get() == list.head.next;
        list.get(0).get() == list.head;
    }

    def "get nodes with get & descendingGet at non-existent index"() {

        DoubleLinkedList list = new DoubleLinkedList();


        when: "add one more elements"
        list.addLast(new NodeD(0))
        list.addLast(new NodeD(1))
        list.addLast(new NodeD(2))
        list.addLast(new NodeD(3))
        list.addLast(new NodeD(4))


        then: "get & check"
        list.get(5) == Optional.empty();
        list.get(-1) == Optional.empty();
        list.descendingGet(-1) == Optional.empty();
        list.descendingGet(-1) == Optional.empty();
    }

}