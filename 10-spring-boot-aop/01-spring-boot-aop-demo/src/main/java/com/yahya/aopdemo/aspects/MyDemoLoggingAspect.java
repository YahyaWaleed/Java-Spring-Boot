package com.yahya.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // tells that this class is an aspect
@Component
public class MyDemoLoggingAspect {

    // add all related advices for logging

    // will apply for any method (with any number of parameters) in any class in the package w
    @Before("execution ( * com.yahya.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("executing @Befpre first");
    }

}
