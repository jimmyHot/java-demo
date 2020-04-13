package org.java.spring.aop.proxy.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOP {

    @Pointcut("execution(* org.java.spring.aop.proxy.aop.Landload.save())")
    public void pt(){

    }

    @Before("pt()")
    public void begin(){
        System.out.println("sprint aop start:");
    }

    @After("pt()")
    public void after(){
        System.out.println("sprint aop after:");
    }
}
