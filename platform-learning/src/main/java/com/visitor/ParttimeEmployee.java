package com.visitor;

public class ParttimeEmployee implements Employee {

    private String name;
    private String salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public ParttimeEmployee(String name, String salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void accept(Department handler) {
        handler.visit(this);
    }
}
