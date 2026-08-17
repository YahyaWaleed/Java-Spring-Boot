package com.yahya.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class PointcutExpressions {
    // pointcut declaration for getters and setters to exclude them
    @Pointcut("execution(* com.yahya.aopdemo.dao.*.get*())")
    public void getter() {};
    @Pointcut("execution(* com.yahya.aopdemo.dao.*.set*())")
    public void setter() {};

    // Pointcut Declaration
    @Pointcut("execution ( * com.yahya.aopdemo.dao.*.*(..))")
    public void forDAOPackage() {};


    // pointcut combining to exclude getters and setters
    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void excludeGettersSetters() {};



}
