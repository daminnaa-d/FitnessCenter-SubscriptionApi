package com.example.subscription.service.impl;

import com.example.subscription.model.Order;
import com.example.subscription.model.Subscription;
import com.example.subscription.repository.OrderRepository;
import com.example.subscription.repository.SubRepository;
import com.example.subscription.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private SubRepository subRepository;

    @Override
    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void addSubToOrder(int orderId, int subId) {
        List<Order> orders = orderRepository.findAll();
        List<Subscription> subs = subRepository.findAll();
        Subscription s =null;
        for(int i=0; i < subs.size(); i++){
            s = subs.get(i);

            if(s.getId() == subId){
                break;
            }
        }
        for(int i=0; i < orders.size(); i++){
            Order o = orders.get(i);

            if(o.getId() == orderId){
                o.setSubscriptionType(s.getName());
                o.setAmount(o.getAmount()+s.getPrice());

                orderRepository.saveAndFlush(o);
            }
        }
    }

    @Override
    public Optional<Order> getOrderById(int id) {
       return orderRepository.findById(id);
    }
}
