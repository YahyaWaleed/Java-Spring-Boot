package com.yahya.springcoredemo.common;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    public BaseballCoach() {
        System.out.println("In construction: " + getClass() /*return the full class */.getSimpleName()/*return the human readable class name after removing the package details */);
    }

    @Override
    public String getDailyWorkout() {
        return "play baseball";
    }
}
