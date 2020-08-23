package com.visitor;

/**
 * 访问者模式是一种对象行为型模式
 */
public abstract class Department {

    public abstract void visit(FulltimeEmployee employee);

    public abstract void visit(ParttimeEmployee employee);

}