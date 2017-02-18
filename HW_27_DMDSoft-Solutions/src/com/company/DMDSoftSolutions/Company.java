package com.company.DMDSoftSolutions;

import com.company.DMDSoftSolutions.Employee.Designer;
import com.company.DMDSoftSolutions.Employee.Developer;
import com.company.DMDSoftSolutions.Employee.Employee;
import com.company.DMDSoftSolutions.Employee.Manager;

import java.util.HashMap;

/**
 * Created by unike on 18.02.2017.
 */
public class Company {

    private HashMap<String,Department> departments;
    private String companyName;


    public Company(String companyName) {
        this.companyName = companyName;
        departments = new HashMap<>();
        departments.put("design", new Department("design", 5));
        departments.put("management", new Department("management",3));
        departments.put("development", new Department("development", 12));
    }

    public void getAll(){
        System.out.println(departments.keySet().toString());
    }


    public void getIs(String departmentName){
        if (!departments.containsKey(departmentName)) {
            System.out.println("Department is not exist");
            return;
        }
        System.out.println(departments.get(departmentName).toString());
    }

    public void get(String departmentName, int employeeId){
        if (!departments.containsKey(departmentName)) {
            System.out.println("Department is not exist");
            return;
        }
        if (!departments.get(departmentName).getEmployees().containsKey(employeeId)){
            System.out.println("Employee is not exist");
            return;
        }
        System.out.println(departments.get(departmentName).getEmployees().get(employeeId).toString());
    }

    public void add(String departmentName, int employeeId, String firstName, String lastName, int salary){
        if (!departments.containsKey(departmentName)) {
            System.out.println("Department is not exist");
            return;
        }
        if (departments.get(departmentName).getCurentEmployeeNum() >= departments.get(departmentName).getMaxEmployeeNum()){
            System.out.println("Department '"+departmentName+"' staff enough");
            return;
        }
        Employee employee;
        switch (departmentName){
            case "design": employee = new Designer(employeeId,firstName,lastName,salary);break;
            case "management": employee = new Manager(employeeId,firstName,lastName,salary);break;
            case "development": employee = new Developer(employeeId,firstName,lastName,salary);break;
            default:employee = null;
        }
        if (null == employee){
            System.out.println("error 1");
            return;
        }
        if (departments.get(departmentName).add(employeeId, employee)) System.out.println("New employee "+employee.getName()+" added to "+departmentName+" department");
        else System.out.println("Employee "+employee.getName()+" NOT added to "+departmentName+" department");
    }

    public String getCompanyName() {
        return companyName;
    }
}
