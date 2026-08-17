package com.yahya.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyCloudLoggingAspect {
    @Before("com.yahya.aopdemo.aspects.PointcutExpressions.excludeGettersSetters()")
    public void cloudLogging() {
        System.out.println("Logging into cloud");
    }
}
