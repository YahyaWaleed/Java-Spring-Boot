package com.yahya.springcoredemo.common;


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
}
