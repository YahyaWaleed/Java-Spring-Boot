package com.yahya.springcoredemo.common;

public class SwimCoach implements Coach {


    public SwimCoach() {
        System.out.println("In construction: " + getClass().getSimpleName());
    }


    @Override
    public String getDailyWorkout() {
        return "warm up 1 Km free";
    }
}
