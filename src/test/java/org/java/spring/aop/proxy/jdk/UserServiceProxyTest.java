package org.java.spring.aop.proxy.jdk;

import org.java.spring.aop.IUserService;
import org.junit.jupiter.api.Test;

class UserServiceProxyTest {

    @Test
    void getProxy() {
        UserServiceProxy userServiceProxy=new UserServiceProxy();
        IUserService proxy = userServiceProxy.getProxy();
        proxy.save();
    }
}