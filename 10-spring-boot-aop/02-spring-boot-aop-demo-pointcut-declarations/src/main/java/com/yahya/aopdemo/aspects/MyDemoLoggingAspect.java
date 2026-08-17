package com.yahya.aopdemo.aspects;

import com.yahya.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import org.aspectj.lang.reflect.MethodSignature; // correct AspectJ type

import java.util.List;
import java.util.Locale;

@Aspect // tells that this class is an aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // print which method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n\n Executing @AfterReturning on method: " + method);

        // start timestamp
        long begin = System.currentTimeMillis();

        // execute method
        Object result = proceedingJoinPoint.proceed();

        // stop timestamp
        long end = System.currentTimeMillis();

        // calculate duration
        long duration = end - begin;
        System.out.println("Duration: " + duration/1000 + "s");

        return null;
    }

    @After( "execution(* com.yahya.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
        // print which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n\n Executing @AfterReturning on method: " + method);


    }

    private void convertNametoUppercase(List<Account> result) {
        for (Account account : result) {
            String upperCaseVersion = account.getName().toUpperCase();
            account.setName(upperCaseVersion);
        }
    }


    @AfterReturning(
            pointcut = "execution(* com.yahya.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result" // will save the returned value from function to an array named result
    )
    public void beforeAddAccountAdvice(JoinPoint joinPoint, List<Account> result) {

        // print which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n\n Executing @AfterReturning on method: " + method);

        // print result of method call
        System.out.println("Result: " + result);

        // modify data
        convertNametoUppercase(result);
    }


}
