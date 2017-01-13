package model;

/**
 * Created by java on 13.01.2017.
 */
public class Middle extends Employee{


    @Override
    public void calculateSalary() {
        System.out.println("Salary = " + baseRate * 2);
    }
}
