package com.example.subscription.controller;

import com.example.subscription.service.SubscriptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subs")
@Api(value = "Subscription Controller class", description = "This class allows to interact with Subscription object")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping("")
    @ApiOperation(value = "Method to get list of subscriptions", response = List.class)
    public ResponseEntity<?> getAllSubs(){
        return ResponseEntity.ok(subscriptionService.getAllSubs());
    }

}
