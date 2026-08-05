package com.yahya.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary  // makes this class the one to choose if no qualifier is set in the dependency injection
public class TennisCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "play tennis now";
    }
}
