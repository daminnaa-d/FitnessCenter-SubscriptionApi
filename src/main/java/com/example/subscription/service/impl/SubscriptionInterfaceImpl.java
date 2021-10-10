package com.example.subscription.service.impl;

import com.example.subscription.db.Database;
import com.example.subscription.model.Subscription;
import com.example.subscription.repository.SubRepository;
import com.example.subscription.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionInterfaceImpl implements SubscriptionService {
    @Autowired
    private SubRepository subRepository;

    @Override
    public List<Subscription> getAllSubs() {
        return subRepository.findAll();
    }

    @Override
    public void addSub(Subscription subscription) {
        subRepository.save(subscription);
    }
}
