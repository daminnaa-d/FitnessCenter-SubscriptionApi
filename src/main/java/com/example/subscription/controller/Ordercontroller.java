package com.example.subscription.controller;

import com.example.subscription.model.Order;
import com.example.subscription.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Api(value = "Order Controller class", description = "This class allows to interact with Order object")
public class Ordercontroller {
    @Autowired
    private OrderService orderService;

    @GetMapping("{id}")
    @ApiOperation(value = "Method to get order by ID", response = List.class)
    public ResponseEntity<?> getOrderById(@PathVariable int id){
        return ResponseEntity.ok(orderService.getOrderById(id));
    }


    @PostMapping("")
    @ApiOperation(value = "Method to create a new order", response = List.class)
    public void createOrder (@RequestBody Order order){
        orderService.createOrder(order);
    }

    @PostMapping("/update/{id}")
    @ApiOperation(value = "Method to update order", response = List.class)
    public void updateOrder(@PathVariable int id, @RequestBody String subId){
        orderService.addSubToOrder(id, Integer.parseInt(subId));
    }
}
