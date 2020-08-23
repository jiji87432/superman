package com.visitor;

public class FulltimeEmployee implements Employee {

    private String name;
    private String salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FulltimeEmployee(String name, String salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void accept(Department handler) {
        handler.visit(this);
    }
}