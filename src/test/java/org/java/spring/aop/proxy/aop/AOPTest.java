package org.java.spring.aop.proxy.aop;

import org.java.spring.aop.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class AOPTest {

    @Test
    public void test(){
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //这里得到的是代理对象....
        Landload landlord = (Landload) ac.getBean("landlord", Landload.class);

        System.out.println(landlord.getClass());

        landlord.service();


    }

}