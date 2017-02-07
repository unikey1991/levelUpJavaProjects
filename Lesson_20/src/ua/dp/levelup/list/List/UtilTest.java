package ua.dp.levelup.list.List;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by java on 07.02.2017.
 */
public class UtilTest {


    @Test
    public void testArraysCopyOf(){
        String[] arr = {"a", "b", "c"};
        String[] arr2 =  Arrays.copyOf(arr, arr.length);

        assertTrue(Arrays.equals(arr, arr2));
    }

    @Test
    public void testArraysAsList() {

        String[] arr = {"a", "b", "c"};
        List<String> list =Arrays.asList(arr);

        ArrayList<String> arl= new ArrayList<>();
        arl.add("c");
        arl.add("d");
        arl.add("e");
        arl.add("f");

        Collections.copy(arl, list);
    }

    @Test
    public void testHashSet() {

        Set<Integer> intSet = new HashSet<>();
        intSet.add(1);
        intSet.add(4);
        intSet.add(3);
        intSet.add(3);
        intSet.add(2);
        intSet.add(3);
        intSet.add(3);
        intSet.add(1);
        intSet.add(2);

        System.out.println(intSet.toString());

        Set<String> hash = new HashSet<>();
        hash.add("castle");
        hash.add("bridge");
        hash.add("castle");
        hash.add("moat");

        System.out.println(hash);

        int id = 525;

        Set<Student>students = new LinkedHashSet<>();
        students.add(new Student(id + 4, "Bill", 24));
        students.add(new Student(id + 1, "Sam", 22));
        students.add(new Student(id + 3, "Tom", 22));
        students.add(new Student(id + 1, "Bob", 22));
        students.add(new Student(id + 3, "Sam", 22));
        students.add(new Student(id + 2, "Bob", 22));

        System.out.println(students.size());
        System.out.println(students);


        Set<Student> treeSet=new TreeSet<>();
        treeSet.add(new Student(1,"Sem",22));
        treeSet.add(new Student(2,"Bob",22));
        treeSet.add(new Student(3,"Tom",22));
        treeSet.add(new Student(1,"Sem",22));
        treeSet.add(new Student(4,"Bill",24));
        treeSet.add(new Student(3,"Sem",22));

        System.out.println(students.size());
        System.out.println(students);


    }
}
