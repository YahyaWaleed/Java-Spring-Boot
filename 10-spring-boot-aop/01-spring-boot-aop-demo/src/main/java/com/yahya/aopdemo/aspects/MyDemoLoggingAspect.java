package com.yahya.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // tells that this class is an aspect
@Component
public class MyDemoLoggingAspect {

    // add all related advices for logging

    @Before("execution (public void addAccount())") // apply function below before executing addAccount() method in any class
    public void beforeAddAccountAdvice() {
        System.out.println("executing @Befpre first");
    }

}
