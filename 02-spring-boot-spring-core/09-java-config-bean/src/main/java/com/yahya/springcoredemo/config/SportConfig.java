package com.yahya.springcoredemo.config;

import com.yahya.springcoredemo.common.Coach;
import com.yahya.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean // to configure it as a Spring Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
