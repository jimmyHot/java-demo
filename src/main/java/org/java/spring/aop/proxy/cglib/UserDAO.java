package org.java.spring.aop.proxy.cglib;

public class UserDAO {

    public void save() {
        System.out.println("target method save is invoke   ~~~~~~~");
    }

}
