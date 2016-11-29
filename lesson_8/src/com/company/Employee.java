package com.company;

/**
 * Created by java on 29.11.2016.
 */
public class Employee extends Person{

    public Employee(String name, String surname){
        super(name, surname);
    }

    @Override
    public void sayHello(String greeting){
        System.out.println(greeting+" opa");
    }
}
