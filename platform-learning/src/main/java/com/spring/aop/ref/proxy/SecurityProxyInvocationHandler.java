package com.spring.aop.ref.proxy;

import com.spring.aop.asm.AccountImpl;
import com.spring.aop.asm.AccountService;
import com.spring.aop.asm.SecurityChecker;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 其不足之处在于：
 * Proxy 是面向接口的，所有使用 Proxy 的对象都必须定义一个接口，而且用这些对象的代码也
 * 必须是对接口编程的：Proxy 生成的对象是接口一致的而不是对象一致的：例子中 Proxy.newProxyInstance
 * 生成的是实现 Account接口的对象而不是 AccountImpl的子类。
 * 这对于软件架构设计，尤其对于既有软件系统是有一定掣肘的。
 * Proxy 毕竟是通过反射实现的，必须在效率上付出代价：有实验数据表明，调用反射比
 * 一般的函数开销至少要大 10 倍。而且，从程序实现上可以看出，对 proxy class
 * 的所有方法调用都要通过使用反射的 invoke 方法。因此，对于性能关键的应用，
 * 使用 proxy class 是需要精心考虑的，以避免反射成为整个应用的瓶颈。
 */
class SecurityProxyInvocationHandler implements InvocationHandler {
    private Object proxyedObject;

    public SecurityProxyInvocationHandler(Object o) {
        proxyedObject = o;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] arguments)
            throws Throwable {
        if (object instanceof AccountService && method.getName()
                                                      .equals("operation")) {
            SecurityChecker.checkSecurity();
        }
        return method.invoke(proxyedObject, arguments);
    }

    public static void main(String[] args) {
        AccountService accountService = (AccountService) Proxy.newProxyInstance(
                AccountService.class.getClassLoader(),
                new Class[]{AccountService.class},
                new SecurityProxyInvocationHandler(new AccountImpl())
        );
        accountService.operation();
    }
}