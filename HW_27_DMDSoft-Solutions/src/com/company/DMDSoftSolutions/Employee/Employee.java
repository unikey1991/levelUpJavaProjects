package com.company.DMDSoftSolutions.Employee;

import java.util.List;

/**
 * Created by unike on 18.02.2017.
 */
public abstract class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee(int employeeId, String firstName, String lastName, int salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }


    public String getName() {
        return firstName+" "+lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
