package com.spring.aop.asm;

/**
 * @author zhangyongji
 * @since 2019-01-23.
 */
public class AccountImpl implements AccountService {
    @Override
    public void operation() {
        System.out.println("operation...");
        //TODO real operation
    }
}
