package com.example.aws_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Spring Boot deployed on AWS EC2!";
    }

    @GetMapping("/health")
    public String health() {
        return "Application is running successfully!";
    }
}
