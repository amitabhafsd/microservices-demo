package com.example.microsvc.demo.orderservice.controller;

import com.example.microsvc.demo.orderservice.client.ProductClient;
import com.example.microsvc.demo.orderservice.service.UserLookupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/orders")
public class OrderControllerV1 {

    private final UserLookupService userLookupService;
    private final ProductClient productClient;

    public OrderControllerV1(UserLookupService userLookupService, ProductClient productClient) {
        this.userLookupService = userLookupService;
        this.productClient = productClient;
    }

    @GetMapping("/{id}")
    public String getOrder(@PathVariable Long id) {

        String user = userLookupService.getUser(id);
        String product = productClient.getProduct(id);

        return "Order " + id + "\n" + user + "\n" + product;
    }
}
