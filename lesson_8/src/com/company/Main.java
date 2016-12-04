package com.company;

public class Main {

    public static void main(String[] args) {

        int i = 90;
        while (i >= 0) {
            System.out.print(i + " ");
            i -= 5;
        }
        System.out.println();


        int a = 257;
        do {
            System.out.print(a % 10);
            a /= 10;
        } while (a > 0);
        System.out.println();

        String arr[] = new String[10];
        for (String s : arr) {
            System.out.print(s + ", ");
        }
        System.out.println();

        int[] nums = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int x :
                nums) {
            sum += x;
            System.out.printf("%d ", x);
        }
        System.out.println();
        System.out.println(sum);

        int i1 = nums.length-1;
        while (i1 >= 0){
            System.out.println(nums[i1]);
            i1--;
        }


        String arr1[] = new String [] {"A B", "V G"};
        for (String x:arr1
             ) {
            System.out.print("Name: "+x);
            System.out.println(", ");
        }
        System.out.println();

        String[] str12 = {"this", "is", "a", "very", "long", "array", "which", "has", "absolutely", "no", "sense"};

        for (String x:str12
                ) {
            System.out.print(x + " - " + x.length()+", ");
        }
        System.out.println();

        ////////////

        Person p = new Person("John", "Doe");
        p.sayHello("Privet");

        Employee e = new Employee("Max","Pyne");
        e.sayHello("dratuti");


    }
}
