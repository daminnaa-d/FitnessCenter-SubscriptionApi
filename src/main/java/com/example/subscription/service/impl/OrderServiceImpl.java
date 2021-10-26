package com.example.subscription.service.impl;

import com.example.subscription.model.Order;
import com.example.subscription.model.Subscription;
import com.example.subscription.repository.OrderRepository;
import com.example.subscription.repository.SubRepository;
import com.example.subscription.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    @HystrixCommand(
            fallbackMethod = "createOrderFallback",
            threadPoolKey = "createOrder",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            })
    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    public void createOrderFallback(Order order) {
        System.out.println("Cannot create an order: Service unavailable!");
    }


    @Override
    @HystrixCommand(
            fallbackMethod = "addSubToOrderFallback",
            threadPoolKey = "addSubToOrder",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            })
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

    public void addSubToOrderFallback(int orderId, int subId) {
        System.out.println("Cannot add the subscription to the order: Service unavailable!");
    }

    @Override
    @HystrixCommand(
            fallbackMethod = "getOrderByIdFallback",
            threadPoolKey = "getOrderById",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            })
    public Optional<Order> getOrderById(int id) {
       return orderRepository.findById(id);
    }

    public Order getOrderByIdFallback(int id) {
        Order order = new Order();
        order.setId(0);
        order.setAmount(0);
        order.setUserId(0);
        order.setValid(false);
        order.setSubscriptionType("Subscription type is not available: Service unavailable!");
        return order;
    }

}
