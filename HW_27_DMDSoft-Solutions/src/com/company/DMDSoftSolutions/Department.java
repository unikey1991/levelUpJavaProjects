package com.company.DMDSoftSolutions;

import com.company.DMDSoftSolutions.Employee.Employee;

import java.util.HashMap;

/**
 * Created by unike on 18.02.2017.
 */
public class Department {

    private String departmentName;
    private HashMap<Integer, Employee> employees;
    private int maxEmployeeNum;
    private int curentEmployeeNum = 0;

    public Department(String departmentName, int maxEmployeeNum) {
        employees = new HashMap<>();
        this.departmentName = departmentName;
        this.maxEmployeeNum = maxEmployeeNum;
    }

    public boolean add (int employeeId, Employee employee){
         if (employees.containsKey(employeeId)) {
             System.out.println("ID "+employeeId+" already exists");
             return false;
         }
         employees.put(employeeId, employee);
         curentEmployeeNum++;
         return true;
    }

    public HashMap<Integer, Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return employees.keySet().toString();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getCurentEmployeeNum() {
        return curentEmployeeNum;
    }

    public int getMaxEmployeeNum() {
        return maxEmployeeNum;
    }
}
