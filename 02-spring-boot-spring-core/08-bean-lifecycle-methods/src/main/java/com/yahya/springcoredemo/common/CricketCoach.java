package com.yahya.springcoredemo.common;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// specific coach class that implement general coach interface



@Component  //tells Spring to manage this class for me
public class CricketCoach implements Coach {


    public CricketCoach() {
        System.out.println("In construction: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "practice fast bowling for 15 minutes :-)";
    }

    //init method (runs right after the object instance is created
    @PostConstruct
    public void startStuff() {
        System.out.println("In startStuff() :  " + getClass().getSimpleName());
    }

    //destroy method (runs after app is stopped)
    @PreDestroy
    public void endStuff() {
        System.out.println("In endStuff() :  " + getClass().getSimpleName());
    }
}
