package controllers;

import models.*;
import java.util.HashMap;

public class EmployeeController {
    private HashMap<String, Employee> employees = Data.getEmployees();
    
    public Employee createEmployee(String name, String user, String password, String scholarship_level){
        Employee employee = new Employee(user, password, name, scholarship_level);
        employees.put(user, employee);

        return employee;
    }

    public Employee getEmployeeByUsername(String username) {
        return employees.get(username);
    }

    public boolean isUserAvailable(String username) {
        return this.getEmployeeByUsername(username) == null ? true : false;
    }

    public HashMap<String, Employee> getEmployees() {
        return employees;
    }
}
