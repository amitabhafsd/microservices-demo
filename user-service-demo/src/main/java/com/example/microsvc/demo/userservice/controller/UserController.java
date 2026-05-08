package com.example.microsvc.demo.userservice.controller;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id) {
        return "User from USER-SERVICE: " + id;
    }

    @KafkaListener(topics = "order-topic", groupId = "user-group")
    public void consume(String message) {
        System.out.println("User Service received: " + message);
    }
}
