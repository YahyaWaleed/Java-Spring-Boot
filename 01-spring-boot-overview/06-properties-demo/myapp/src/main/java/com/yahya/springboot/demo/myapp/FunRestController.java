package com.yahya.springboot.demo.myapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //used to handle HTTP requests
public class FunRestController {


    //Injecting application properties
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + "\n" +  "Team: " + teamName;
    }


    @GetMapping("/" /* main page (aka root url path */) // when u recieve a GET request with the given URL (argument), do the following
    public String sayHello() {
        return "Hello world!";
    }

    @GetMapping("/test")
    public String test() {
        return "Test endpoint works!";
    }
}
/*
Spring boot  framework for java backend development
	@RestController: handles http requests
	@Service: problem solving (business logic)
	@Repository: CRUD operations on database

 */

