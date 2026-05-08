package com.example.microsvc.demo.orderservice.service;

import com.example.microsvc.demo.orderservice.client.UserClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class UserLookupService {

    private final UserClient userClient;

    public UserLookupService(UserClient userClient) {
        this.userClient = userClient;
    }

    @CircuitBreaker(name = "userService", fallbackMethod = "userFallback")
    public String getUser(Long id) {
        return userClient.getUser(id);
    }

    public String userFallback(Long id, Throwable ex) {
        return "User Service is DOWN (fallback response)";
    }
}
