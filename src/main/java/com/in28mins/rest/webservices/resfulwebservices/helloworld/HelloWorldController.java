package com.in28mins.rest.webservices.resfulwebservices.helloworld;

import org.springframework.web.bind.annotation.*;

//Controller: Tell Spring that this is a controller- meaning: this would be handling HTTP requests
@RestController  // this is to tell Spring MVC that this is going to handle Rest requests
@CrossOrigin(origins="http://localhost:4200") //to tell Springboot that I will allow to be getting request from localhost:4200

public class HelloWorldController {
    //create a method to return "Hello World"
    // Use GET method
    //Use URI- /hello-world
    //so if someone go to browser and send a GET request to /hello-world, I would send him some text "Hello World"
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    //hello World- bean
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World Bean");
    }

    //with variable
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        //throw new RuntimeException("Something went wrong");
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
