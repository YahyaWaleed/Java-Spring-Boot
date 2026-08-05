package com.yahya.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{


    public TennisCoach() {
        System.out.println("In construction: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "play tennis now";
    }
}
