package com.company

import spock.lang.Specification

/**
 * Created by unike on 05.02.2017.
 */
class ArraysTest extends Specification {

    def "copyOf()"() {

        given: "add one more elements"
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(0)
        arrayList1.add(1)
        arrayList1.add(2)

        when: "copy with copyOf()"
        Integer[] arr1 = Arrays.copyOf(arrayList1 as Integer[], arrayList1.size())
        Integer[] arr2 = Arrays.copyOf(arrayList1 as Integer[], 5)
        Integer[] arr3 = Arrays.copyOf(arrayList1 as Integer[], 2)

        then: "check"
        arr1.length == 3
        arr1.toString() == "[0, 1, 2]"
        arr2.length == 5
        arr2.toString() == "[0, 1, 2, null, null]"
        arr3.length == 2
        arr3.toString() == "[0, 1]"

    }

    def "copyOfRange()"() {

        given: "add one more elements"
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(0)
        arrayList1.add(1)
        arrayList1.add(2)
        arrayList1.add(3)

        when: "copy with copyOfRange()"
        Integer[] arr1 = Arrays.copyOfRange(arrayList1 as Integer[], 1, 3)
        Integer[] arr2 = Arrays.copyOfRange(arrayList1 as Integer[], 0, 4)
        Integer[] arr3 = Arrays.copyOfRange(arrayList1 as Integer[], 3, 5)


        then: "check"
        arr1.length == 2
        arr1.toString() == "[1, 2]"
        arr2.length == 4
        arr2.toString() == "[0, 1, 2, 3]"
        arr3.length == 2
        arr3.toString() == "[3, null]"

    }

    def "toString()"() {

        given: "add one more elements"
        ArrayList<Integer> arrayList1 = new ArrayList<>();

        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(0)
        arrayList2.add(1)

        ArrayList<Integer> arrayList3 = new ArrayList<>();
        arrayList3.add(0)
        arrayList3.add(1)
        arrayList3.add(2)

        when: "use toString()"
        String arr1 = Arrays.toString(arrayList1);
        String arr2 = Arrays.toString(arrayList2);
        String arr3 = Arrays.toString(arrayList3);

        then: "check"
        arr1 == "[[]]"
        arr2 == "[[0, 1]]"
        arr3 == "[[0, 1, 2]]"

    }

    def "sort()"() {

        given: "add one more elements"
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(5)
        arrayList1.add(7)
        arrayList1.add(2)
        arrayList1.add(4)
        arrayList1.add(6)
        arrayList1.add(1)

        when: "copy and sort"
        Integer[] arr1 = Arrays.copyOf(arrayList1 as Integer[], arrayList1.size())
        Integer[] arr2 = Arrays.copyOf(arrayList1 as Integer[], arrayList1.size())
        Integer[] arr3 = Arrays.copyOf(arrayList1 as Integer[], arrayList1.size())
        Arrays.sort(arr2, 4, 6)
        Arrays.sort(arr3)


        then: "check"
        arr1.toString() == "[5, 7, 2, 4, 6, 1]"
        arr2.toString() == "[5, 7, 2, 4, 1, 6]"
        arr3.toString() == "[1, 2, 4, 5, 6, 7]"

    }

    def "binarySearch()"() {

        given: "add one more elements"
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(0)
        arrayList1.add(1)
        arrayList1.add(2)

        when: "use binarySearch()"
        int res1 = Arrays.binarySearch(arrayList1 as Integer[], 1)
        int res2 = Arrays.binarySearch(arrayList1 as Integer[], 10)
        int res3 = Arrays.binarySearch(arrayList1 as Integer[], -4)

        then: "check"
        res1 == 1;
        res2 == -4;
        res3 == -1;

    }

    def "fill()"() {

        given: "add one more elements"
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(0)
        arrayList1.add(1)
        arrayList1.add(2)
        arrayList1.add(3)
        arrayList1.add(4)

        when: "aagg"
        Integer[] arr1 = arrayList1.toArray() as Integer[]
        Integer[] arr2 = Arrays.copyOf(arr1,arr1.length)
        Integer[] arr3 = Arrays.copyOf(arr1,arr1.length)
        Arrays.fill(arr2 as Integer[], 1)
        Arrays.fill(arr3 as Integer[], 0,3,777)


        then: "check"
        arr1.toString() == "[0, 1, 2, 3, 4]"
        arr2.toString() == "[1, 1, 1, 1, 1]"
        arr3.toString() == "[777, 777, 777, 3, 4]"

    }

    def "equals()"() {

        given: "add one more elements"
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("0 index")
        arrayList1.add("1 index")
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("0 index")
        arrayList2.add("1 index")
        ArrayList<String> arrayList3 = arrayList1

        when: "aagg"
        boolean b1 = arrayList1.equals(arrayList2)
        boolean b2 = arrayList2.equals(arrayList3)
        boolean b3 = arrayList3.equals(arrayList1)

        then: "check"
        b1
        b2
        b3

    }

    def "asList()"() {

        given: "add array & use asList()"
        Integer[] int1 = [0,1,2,3,4] as Integer[]
        List<Integer> List2 = Arrays.asList(int1)
        ArrayList<Integer> arrayList3 = Arrays.copyOf(List2 as Integer[],List2.size())



        when: "copy one more"
        List2.set(0, 777)
        ArrayList<Integer> arrayList4 = Arrays.copyOf(List2 as Integer[],List2.size())
        ArrayList<Integer> arrayList5 = Arrays.copyOf(arrayList4 as Integer[],List2.size())




        then: "check"
        arrayList3.toString() == "[0, 1, 2, 3, 4]"
        int1.toString() == "[777, 1, 2, 3, 4]"
        List2.toString() == "[777, 1, 2, 3, 4]"
        List2.get(0) == arrayList5.getAt(0)

    }


}
