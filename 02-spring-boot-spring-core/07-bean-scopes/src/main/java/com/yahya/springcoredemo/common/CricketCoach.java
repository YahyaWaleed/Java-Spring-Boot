package com.yahya.springcoredemo.common;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// specific coach class that implement general coach interface


@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // this changes the bean scope from singleton (default) to prototype
// so now for each instantization, we will have an instance (they reference to different objects)

@Component  //tells Spring to manage this class for me
public class CricketCoach implements Coach {


    public CricketCoach() {
        System.out.println("In construction: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "practice fast bowling for 15 minutes :-)";
    }
}
