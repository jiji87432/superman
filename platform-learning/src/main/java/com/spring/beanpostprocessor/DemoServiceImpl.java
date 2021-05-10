package com.spring.beanpostprocessor;

/**
 * @author jiji
 */
public class DemoServiceImpl implements DemoService, NameInit {
    private String name;

    @Override
    public void sayHello() {
        System.out.println("hello " + name);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}