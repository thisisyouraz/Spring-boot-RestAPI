package com.example.restfulserviceproject.others;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path="/hello/var-name/{name}")
    public HelloWorld message(@PathVariable String name){

        return (new HelloWorld("Hello "+name));
    }

}
