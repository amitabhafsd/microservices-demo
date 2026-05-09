package com.example.reactive.demo;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notification {

    private String message;
    private long timestamp;

}
