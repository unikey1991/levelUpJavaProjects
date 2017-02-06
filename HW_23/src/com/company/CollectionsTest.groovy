package com.company

import spock.lang.Specification

/**
 * Created by unike on 05.02.2017.
 */
class CollectionsTest extends Specification {
    def "copy()"() {

        given: "add one more elements"
        ArrayList <Integer> arrayList1 = new ArrayList<>()
        arrayList1.add(0)

        ArrayList <Integer> arrayList2 = new ArrayList <>(100)
        arrayList2.add(1)
        arrayList2.add(2)
        ArrayList <Integer> arrayList3 = new ArrayList <>()
        ArrayList <Integer> arrayList4 = new ArrayList <>()


        when: "use copy()"
        Collections.copy(arrayList2,arrayList1)
        Collections.copy(arrayList3,arrayList2)
        arrayList3.add(4)
        arrayList3.add(5)
        Collections.copy(arrayList4, arrayList3)



        then: "check"
        arrayList1.toString() == "[0, 1, 2, 3]"
        arrayList2.toString() == "[0, 1, 2, 3]"
        arrayList3.toString() == "[0, 1, 2, 3, 4, 5]"
        arrayList4.toString() == "[0, 1, 2, 3 4, 5]"


    }

    def "disjoint()"() {

        given: "create collections"
        ArrayList <Integer> arrayList1 = new ArrayList<>()
        ArrayList <Integer> arrayList2 = new ArrayList <>()
        ArrayList <Integer> arrayList3 = new ArrayList <>()

        LinkedList<Integer> linkedList1 = new LinkedList<>()
        LinkedList<Integer> linkedList2 = new LinkedList<>()
        LinkedList<Integer> linkedList3 = new LinkedList<>()


        when: "add one more elements"
        arrayList1.add(0)

        arrayList2.add(1)
        arrayList2.add(2)

        arrayList3.add(1)

        linkedList1.add(0)
        linkedList1.add(1)
        linkedList1.add(2)

        linkedList2.add(1)

        linkedList3.add(2)

        then: "check"
        Collections.disjoint(arrayList1, arrayList2)
        Collections.disjoint(arrayList1, arrayList3)
        !Collections.disjoint(arrayList2, arrayList3)

        !Collections.disjoint(linkedList1, linkedList2)
        !Collections.disjoint(linkedList1, linkedList3)
        Collections.disjoint(linkedList2, linkedList3)

        Collections.disjoint(arrayList1, linkedList2)
        !Collections.disjoint(arrayList2, linkedList1)

    }

    def "fill()"() {

        given: "add one more elements"
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(0)
        arrayList1.add(1)
        arrayList1.add(2)
        arrayList1.add(3)
        arrayList1.add(4)

        ArrayList<Integer> arrayList2 = new ArrayList<>(3);

        when: "aagg"
        Collections.fill(arrayList1, 555)


        then: "check"
        arrayList1.toString() == "[555, 555, 555, 555, 555]"

    }

    def "frequency()"() {

        given: "create collections"
        ArrayList <Integer> arrayList1 = new ArrayList<>()
        ArrayList <Integer> arrayList2 = new ArrayList <>()

        LinkedList<Integer> linkedList1 = new LinkedList<>()
        LinkedList<Integer> linkedList2 = new LinkedList<>()

        when: "add one more elements"
        arrayList1.add(0)

        arrayList2.add(1)
        arrayList2.add(2)


        linkedList1.add(0)
        linkedList1.add(1)
        linkedList1.add(2)
        linkedList1.add(2)
        linkedList1.add(2)

        linkedList2.add(1)


        then: "check"
        Collections.frequency(linkedList1, 2) == 3
        Collections.frequency(linkedList1, 9) == 0
        Collections.frequency(arrayList2, 2) == 1



    }

    def "indexOfSubList()"() {

        given: "create collections"
        ArrayList <Integer> arrayList1 = new ArrayList<>()
        ArrayList <Integer> arrayList2 = new ArrayList <>()

        LinkedList<Integer> linkedList1 = new LinkedList<>()
        LinkedList<Integer> linkedList2 = new LinkedList<>()

        when: "add one more elements"
        arrayList1.add(3)
        arrayList1.add(4)

        arrayList2.add(1)
        arrayList2.add(2)
        arrayList2.add(3)
        arrayList2.add(4)


        linkedList1.add(0)
        linkedList1.add(1)
        linkedList1.add(2)
        linkedList1.add(3)
        linkedList1.add(4)

        linkedList2.add(1)
        linkedList2.add(2)

        then: "check"
        Collections.indexOfSubList(arrayList2, arrayList1) == 2
        Collections.indexOfSubList(arrayList1, arrayList2) == -1

        Collections.indexOfSubList(linkedList2, linkedList1) == -1
        Collections.indexOfSubList(linkedList1, linkedList2) == 1

    }

    def "lastIndexOfSubList()"() {

        given: "create collections"
        ArrayList <Integer> arrayList1 = new ArrayList<>()
        ArrayList <Integer> arrayList2 = new ArrayList <>()

        LinkedList<Integer> linkedList1 = new LinkedList<>()
        LinkedList<Integer> linkedList2 = new LinkedList<>()

        when: "add one more elements"
        arrayList1.add(3)
        arrayList1.add(4)

        arrayList2.add(1)
        arrayList2.add(2)
        arrayList2.add(3)
        arrayList2.add(4)


        linkedList1.add(0)
        linkedList1.add(1)
        linkedList1.add(2)
        linkedList1.add(3)
        linkedList1.add(4)

        linkedList2.add(1)
        linkedList2.add(2)

        then: "check"
        Collections.lastIndexOfSubList(arrayList2, arrayList1) == 2
        Collections.lastIndexOfSubList(arrayList1, arrayList2) == -1

        Collections.lastIndexOfSubList(linkedList2, linkedList1) == -1
        Collections.lastIndexOfSubList(linkedList1, linkedList2) == 1

    }

    def "list()"() {

        given: "create collections & Integer"
        ArrayList <Integer> arrayList1 = new ArrayList<>()

        Vector v = new Vector()
        v.add("A");
        v.add("B");
        v.add("C");
        v.add("D");
        v.add("E");
        Enumeration e = v.elements();

        when: "use list()"
        arrayList1 = Collections.list(e)



                then: "check"
        arrayList1.toString() == "[A, B, C, D, E]"
    }

    def "max()"() {

        given: "create collections"
        ArrayList <Integer> arrayList1 = new ArrayList<>()
        ArrayList <Integer> arrayList2 = new ArrayList <>()

        LinkedList<Integer> linkedList1 = new LinkedList<>()
        LinkedList<Integer> linkedList2 = new LinkedList<>()

        when: "add one more elements"
        arrayList1.add(3)
        arrayList1.add(4)

        arrayList2.add(1)
        arrayList2.add(2)
        arrayList2.add(3)
        arrayList2.add(4)


        linkedList1.add(0)
        linkedList1.add(1)
        linkedList1.add(2)
        linkedList1.add(3)
        linkedList1.add(4)

        linkedList2.add(1)
        linkedList2.add(2)

        then: "check"
        Collections.max(arrayList1) == 4
        Collections.max(arrayList2) == 4
        Collections.max(linkedList1) == 4
        Collections.max(linkedList2) == 2


    }

    def "min()"() {

        given: "create collections"
        ArrayList <Integer> arrayList1 = new ArrayList<>()
        ArrayList <Integer> arrayList2 = new ArrayList <>()

        LinkedList<Integer> linkedList1 = new LinkedList<>()
        LinkedList<Integer> linkedList2 = new LinkedList<>()

        when: "add one more elements"
        arrayList1.add(3)
        arrayList1.add(4)

        arrayList2.add(1)
        arrayList2.add(2)
        arrayList2.add(3)
        arrayList2.add(4)


        linkedList1.add(0)
        linkedList1.add(1)
        linkedList1.add(2)
        linkedList1.add(3)
        linkedList1.add(4)

        linkedList2.add(1)
        linkedList2.add(2)

        then: "check"
        Collections.min(arrayList1) == 3
        Collections.min(arrayList2) == 1
        Collections.min(linkedList1) == 0
        Collections.min(linkedList2) == 1

    }

    def "nCopies()"() {

        given: "create collections"
        ArrayList <Integer> arrayList1 = Collections.nCopies(5,3)

        LinkedList<Integer> linkedList1 = Collections.nCopies(3, 50)

        List<Integer> list = Collections.nCopies(3, 50)

        when: "add one more elements"
        arrayList1.add(4)
        arrayList1.add(0)

        linkedList1.add(5)
        linkedList1.add(50)


        then: "check"
        arrayList1.toString() == "[3, 3, 3, 3, 3, 4, 0]"
        linkedList1.toString() == "[50, 50, 50, 5, 50]"
        list.toString() == "[50, 50, 50]"


    }

    def "replaceAll()"() {

        given: "create collections"
        ArrayList <Integer> arrayList1 = new ArrayList<>()

        LinkedList<Integer> linkedList1 = new LinkedList<>()

        when: "add one more elements"
        arrayList1.add(3)
        arrayList1.add(4)
        arrayList1.add(4)
        arrayList1.add(4)
        arrayList1.add(5)
        arrayList1.add(6)

        linkedList1.add(0)
        linkedList1.add(1)
        linkedList1.add(2)
        linkedList1.add(2)
        linkedList1.add(3)
        linkedList1.add(3)
        linkedList1.add(4)


        then: "check"
        arrayList1.toString() == "[3, 4, 4, 4, 5, 6]"
        Collections.replaceAll(arrayList1, 4, 777)
        arrayList1.toString() == "[3, 777, 777, 777, 5, 6]"

        Collections.replaceAll(linkedList1, 2, 3)
        linkedList1.toString() == "[0, 1, 3, 3, 3, 3, 4]"
        Collections.replaceAll(linkedList1, 3, 0)
        linkedList1.toString() == "[0, 1, 0, 0, 0, 0, 4]"

    }

    def "reverse()"() {

        given: "create collections"
        ArrayList <Integer> arrayList1 = new ArrayList<>()

        LinkedList<Integer> linkedList1 = new LinkedList<>()

        when: "add one more elements"
        arrayList1.add(3)
        arrayList1.add(4)
        arrayList1.add(5)
        arrayList1.add(6)

        linkedList1.add(0)
        linkedList1.add(1)
        linkedList1.add(2)
        linkedList1.add(2)
        linkedList1.add(3)
        linkedList1.add(3)
        linkedList1.add(4)



        then: "check"
        arrayList1.toString() == "[3, 4, 5, 6]"
        Collections.reverse(arrayList1)
        arrayList1.toString() == "[6, 5, 4, 3]"
        Collections.reverse(arrayList1)
        arrayList1.toString() == "[3, 4, 5, 6]"

        linkedList1.toString() == "[0, 1, 2, 2, 3, 3, 4]"
        Collections.reverse(linkedList1)
        linkedList1.toString() == "[4, 3, 3, 2, 2, 1, 0]"


    }

    def "reverseOrder()"() {

        given: "create collections"
        ArrayList <Integer> arrayList1 = new ArrayList<>()

        LinkedList<Integer> linkedList1 = new LinkedList<>()

        when: "add one more elements"
        arrayList1.add(3)
        arrayList1.add(4)
        arrayList1.add(5)
        arrayList1.add(6)

        linkedList1.add(0)
        linkedList1.add(1)
        linkedList1.add(2)
        linkedList1.add(2)
        linkedList1.add(3)
        linkedList1.add(3)
        linkedList1.add(4)



        then: "check"
        linkedList1.toString() == "[0, 1, 2, 2, 3, 3, 4]"
        int i1 = Collections.reverseOrder().compare(linkedList1.get(2), 10)
        i1 == 1

        int i2 = Collections.reverseOrder().compare(linkedList1.get(4), 3)
        i2 == 0

    }

    def "rotate()"() {

        given: "create collections"
        ArrayList <Integer> arrayList1 = new ArrayList<>()

        LinkedList<Integer> linkedList1 = new LinkedList<>()

        when: "add one more elements"
        arrayList1.add(3)
        arrayList1.add(4)
        arrayList1.add(5)
        arrayList1.add(6)

        linkedList1.add(0)
        linkedList1.add(1)
        linkedList1.add(2)
        linkedList1.add(2)
        linkedList1.add(3)
        linkedList1.add(3)
        linkedList1.add(4)


        then: "check"
        arrayList1.toString() == "[3, 4, 5, 6]"
        Collections.rotate(arrayList1, 2)
        arrayList1.toString() == "[5, 6, 3, 4]"
        Collections.rotate(arrayList1, 1)
        arrayList1.toString() == "[4, 5, 6, 3]"


        linkedList1.toString() == "[0, 1, 2, 2, 3, 3, 4]"
        Collections.rotate(linkedList1, 2)
        linkedList1.toString() == "[3, 4, 0, 1, 2, 2, 3]"
    }

    def "shuffle()"() {

        given: "create collections"
        ArrayList <Integer> arrayList1 = new ArrayList<>()

        LinkedList<Integer> linkedList1 = new LinkedList<>()

        when: "add one more elements"
        arrayList1.add(3)
        arrayList1.add(4)
        arrayList1.add(5)
        arrayList1.add(6)

        linkedList1.add(0)
        linkedList1.add(1)
        linkedList1.add(2)
        linkedList1.add(2)
        linkedList1.add(3)
        linkedList1.add(3)
        linkedList1.add(4)


        then: "check"
        arrayList1.toString() == "[3, 4, 5, 6]"
        Collections.shuffle(arrayList1)
        arrayList1.toString() != "[3, 4, 5, 6]"


        linkedList1.toString() == "[0, 1, 2, 2, 3, 3, 4]"
        Collections.shuffle(linkedList1)
        linkedList1.toString() != "[0, 1, 2, 2, 3, 3, 4]"
        String s1 = linkedList1.toString()
        Collections.shuffle(linkedList1)
        linkedList1.toString() != "[0, 1, 2, 2, 3, 3, 4]"
        linkedList1.toString() != s1

    }

    def "sort()"() {

        given: "create collections"
        ArrayList <Integer> arrayList1 = new ArrayList<>()

        LinkedList<Integer> linkedList1 = new LinkedList<>()

        when: "add one more elements"
        arrayList1.add(9)
        arrayList1.add(8)
        arrayList1.add(5)
        arrayList1.add(6)

        linkedList1.add(0)
        linkedList1.add(1)
        linkedList1.add(2)
        linkedList1.add(2)
        linkedList1.add(3)
        linkedList1.add(3)
        linkedList1.add(4)


        then: "check"
        arrayList1.toString() == "[9, 8, 5, 6]"
        Collections.sort(arrayList1)
        arrayList1.toString() == "[5, 6, 8, 9]"
        Collections.sort(arrayList1, new Comparator<Integer>() {
            @Override
            int compare(Integer o1, Integer o2) {
                if (o1 < o2) return 1;
                else if (o1 == o2) return 0;
                else return -1
            }
        })
        arrayList1.toString() == "[9, 8, 6, 5]"

    }

    def "swap()"() {

        given: "create collections"
        ArrayList <Integer> arrayList1 = new ArrayList<>()

        LinkedList<Integer> linkedList1 = new LinkedList<>()

        when: "add one more elements"
        arrayList1.add(3)
        arrayList1.add(4)
        arrayList1.add(5)
        arrayList1.add(6)

        linkedList1.add(0)
        linkedList1.add(1)
        linkedList1.add(2)
        linkedList1.add(2)
        linkedList1.add(3)
        linkedList1.add(3)
        linkedList1.add(4)


        then: "check"
        arrayList1.toString() == "[3, 4, 5, 6]"
        Collections.swap(arrayList1, 1, 3)
        arrayList1.toString() == "[3, 6, 5, 4]"

        linkedList1.toString() == "[0, 1, 2, 2, 3, 3, 4]"
        Collections.swap(linkedList1, 2, 5)
        linkedList1.toString() == "[0, 1, 3, 2, 3, 2, 4]"



    }
}
