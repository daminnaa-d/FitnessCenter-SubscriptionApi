package com.example.subscription.service;

import com.example.subscription.model.Order;

import java.util.Optional;

public interface OrderService {
    void createOrder(Order order);
    void addSubToOrder(int orderId, int subId);
    Optional<Order> getOrderById(int id);

}
