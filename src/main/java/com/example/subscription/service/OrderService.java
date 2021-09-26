package com.example.subscription.service;

import com.example.subscription.model.Order;

public interface OrderService {
    void createOrder(Order order);
    void addSubToOrder(int orderId, int subId);
    Order getOrderById(int id);

}
