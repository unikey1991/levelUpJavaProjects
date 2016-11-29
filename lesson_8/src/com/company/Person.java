package com.company;

/**
 * Created by java on 29.11.2016.
 */
public class Person {

    protected String name;
    protected String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void sayHello(String greeting){
        System.out.println(greeting+" ebana");
    }
}
