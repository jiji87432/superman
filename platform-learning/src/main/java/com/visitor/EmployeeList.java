package com.visitor;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {

    private List<Employee> list = new ArrayList<>();

    public void addEmployee(Employee employee) {
        list.add(employee);
    }

    public void accept(Department department) {
        for (Employee employee : list) {
            employee.accept(department);
        }
    }

    public static void main(String[] args) {
        EmployeeList list = new EmployeeList();
        Employee employee1 = new FulltimeEmployee("张三", "1000");
        Employee employee2 = new ParttimeEmployee("李四", "500");
        Employee employee3 = new ParttimeEmployee("王五", "400");
        list.addEmployee(employee1);
        list.addEmployee(employee2);
        list.addEmployee(employee3);

        Department department1 = new FADepartment();
        list.accept(department1);
    }
}