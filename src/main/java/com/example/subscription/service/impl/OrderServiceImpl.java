package com.example.subscription.service.impl;

import com.example.subscription.db.Database;
import com.example.subscription.model.Order;
import com.example.subscription.model.Subscription;
import com.example.subscription.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public void createOrder(Order order) {
        Database.getDatabase().getOrders().add(order);
    }

    @Override
    public void addSubToOrder(int orderId, int subId) {
        List<Order> orders = Database.getDatabase().getOrders();
        List<Subscription> subs = Database.getDatabase().getSubs();
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
                o.getSubscriptionType().add(s.getName());
                o.setAmount(o.getAmount()+s.getPrice());

                orders.set(i, o);
            }
        }



    }

    @Override
    public Order getOrderById(int id) {
        for (Order order:Database.getDatabase().getOrders()) {
            if(order.getId() == id){
                return order;
            }
        }
        return null;
    }
}
