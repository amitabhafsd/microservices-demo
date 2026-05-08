package com.example.microsvc.demo.orderservice.controller;

import com.example.microsvc.demo.orderservice.producer.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderControllerV2 {
    @Autowired
    private OrderProducer producer;

    @GetMapping("/{id}")
    public String getOrder(@PathVariable Long id) {

        producer.sendOrder("Order created: " + id);

        return "Order " + id + " sent to Kafka";
    }
}
