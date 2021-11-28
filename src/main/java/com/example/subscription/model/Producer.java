package com.example.subscription.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final String TOPIC = "orders";

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public String orderNotify(Order order) {
        System.out.println(String.format("#### -> Producing order to notification service -> %s", order));
        this.kafkaTemplate.send(TOPIC, order);
        return "Successfully!";
    }
}
