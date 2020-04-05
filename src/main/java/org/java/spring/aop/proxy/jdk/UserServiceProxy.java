package org.java.spring.aop.proxy.jdk;

import org.java.spring.aop.IUserService;
import org.java.spring.aop.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserServiceProxy {


    //持有目标对象
    UserServiceImpl userService = new UserServiceImpl();

    public IUserService getProxy() {
        return (IUserService) Proxy.newProxyInstance(UserServiceProxy.class.getClassLoader(), userService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("proxy class add log start....");
                method.invoke(userService, args);
                System.out.println("proxy class add log end....");
                return proxy;
            }
        });
    }

}
