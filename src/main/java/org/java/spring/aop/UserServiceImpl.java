package org.java.spring.aop;

import org.java.spring.aop.IUserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements IUserService {

    @Override
    public void save() {
        System.out.println("target method save is invoke   ~~~~~~~");
    }
}
