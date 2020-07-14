package com.spring.aop.asm;

public class AccountWithSecurityCheck implements AccountService {
    private AccountService accountService;

    public AccountWithSecurityCheck(AccountService AccountService) {
        this.accountService = AccountService;
    }

    @Override
    public void operation() {
        SecurityChecker.checkSecurity();
        accountService.operation();
    }

}