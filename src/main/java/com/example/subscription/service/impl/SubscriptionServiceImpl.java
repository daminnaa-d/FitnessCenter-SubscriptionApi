package com.example.subscription.service.impl;

import com.example.subscription.model.Subscription;
import com.example.subscription.repository.SubRepository;
import com.example.subscription.service.SubscriptionService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Autowired
    private SubRepository subRepository;

    @Override
    @HystrixCommand(
            fallbackMethod = "getAllSubsFallback",
            threadPoolKey = "getAllSubs",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            })
    public List<Subscription> getAllSubs() {
        return subRepository.findAll();
    }

    public  List<Subscription> getAllSubsFallback() {
        return null;
    }

    @Override
    @HystrixCommand(
            fallbackMethod = "addSubFallback",
            threadPoolKey = "addSub",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            })
    public void addSub(Subscription subscription) {
        subRepository.save(subscription);
    }

    public void addSubFallback(Subscription subscription) {
        System.out.println("Cannot add subscription: Service unavailable!");
    }
}
