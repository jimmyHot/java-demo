package org.java.spring.aop.proxy.cglib;

import org.junit.jupiter.api.Test;


class ProxyFactoryTest {

    @Test
    void testProxy(){
        ProxyFactory proxyFactory=new ProxyFactory(new UserDAO());
        UserDAO proxyInstance = (UserDAO) proxyFactory.getProxyInstance();
        proxyInstance.save();

    }

}