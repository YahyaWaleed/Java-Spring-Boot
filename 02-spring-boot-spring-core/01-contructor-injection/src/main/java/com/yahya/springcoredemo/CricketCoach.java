package com.yahya.springcoredemo;


import org.springframework.stereotype.Component;

// specific coach class that implement general coach interface



@Component  //tells Spring to manage this class for me
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "practice fast bowling for 15 minutes";
    }
}
