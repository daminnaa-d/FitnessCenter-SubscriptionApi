package com.example.subscription.controller;

import com.example.subscription.model.Order;
import com.example.subscription.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class Ordercontroller {
    @Autowired
    private OrderService orderService;

    @GetMapping("{id}")
    public ResponseEntity<?> getOrderById(@PathVariable int id){
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PostMapping("")
    public void createOrder (@RequestBody Order order){
        orderService.createOrder(order);
    }

    @PostMapping("/update/{id}")
    public void updateOrder(@PathVariable int id, @RequestBody String subId){
        orderService.addSubToOrder(id, Integer.parseInt(subId));
    }
}
