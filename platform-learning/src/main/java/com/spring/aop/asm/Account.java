package com.spring.aop.asm;

public class Account {
    public void operation() { 
        System.out.println("operation..."); 
        //TODO real operation 
    }

    public static void main(String[] args) {
        Account account = new Account();
        account.operation();
    }
}