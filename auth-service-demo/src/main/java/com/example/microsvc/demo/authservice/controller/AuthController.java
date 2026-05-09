package com.example.microsvc.demo.authservice.controller;

import com.example.microsvc.demo.authservice.dto.AuthRequest;
import com.example.microsvc.demo.authservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
        // fake validation for learning
        if (Objects.equals(request.getUsername(), "admin") && Objects.equals(request.getPassword(), "admin")) {
            return jwtUtil.generateToken(request.getUsername());
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
    }
}
