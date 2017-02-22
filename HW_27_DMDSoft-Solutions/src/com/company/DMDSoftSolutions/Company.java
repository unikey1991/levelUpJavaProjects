package com.company.DMDSoftSolutions;

import com.company.DMDSoftSolutions.Employee.Designer;
import com.company.DMDSoftSolutions.Employee.Developer;
import com.company.DMDSoftSolutions.Employee.Employee;
import com.company.DMDSoftSolutions.Employee.Manager;

import java.util.HashMap;
import java.util.Map;

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


    public void getIs(String... params){
        if (!departments.containsKey(params[1])) {
            System.out.println("Department is not exist");
            return;
        }
        System.out.println(departments.get(params[1]).toString());
    }

    public void get(String... params){
        if (!departments.containsKey(params[1])) {
            System.out.println("Department is not exist");
            return;
        }
        if (!departments.get(params[1]).getEmployees().containsKey(Integer.parseInt(params[2]))){
            System.out.println("Employee is not exist");
            return;
        }
        System.out.println(departments.get(params[1]).getEmployees().get(Integer.parseInt(params[2])).toString());
    }

    public void add(String... params){
        if (!departments.containsKey(params[1])) {
            System.out.println("Department is not exist");
            return;
        }
        if (departments.get(params[1]).getCurentEmployeeNum() >= departments.get(params[1]).getMaxEmployeeNum()){
            System.out.println("Department '"+params[1]+"' staff enough");
            return;
        }
        Employee employee;
        switch (params[1]){
            case "design": employee = new Designer(Integer.parseInt(params[2]),params[3],params[4],Integer.parseInt(params[5]));break;
            case "management": employee = new Developer(Integer.parseInt(params[2]),params[3],params[4],Integer.parseInt(params[5]));break;
            case "development": employee = new Developer(Integer.parseInt(params[2]),params[3],params[4],Integer.parseInt(params[5]));break;
            default:employee = null;
        }
        if (null == employee){
            System.out.println("error 1");
            return;
        }
        if (departments.get(params[1]).add(Integer.parseInt(params[2]), employee)) System.out.println("New employee "+employee.getName()+" added to "+params[1]+" department");
        else System.out.println("Employee "+employee.getName()+" NOT added to "+params[1]+" department");
    }

    public String getCompanyName() {
        return companyName;
    }
}
