package model;

/**
 * Created by java on 13.01.2017.
 */
public class Junior extends Employee{


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void calculateSalary() {
        System.out.println("Salary = " + baseRate);
    }
}
