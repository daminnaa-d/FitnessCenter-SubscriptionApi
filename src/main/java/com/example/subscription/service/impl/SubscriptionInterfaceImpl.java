package com.example.subscription.service.impl;

import com.example.subscription.db.Database;
import com.example.subscription.model.Subscription;
import com.example.subscription.service.SubscriptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionInterfaceImpl implements SubscriptionService {
    @Override
    public List<Subscription> getAllSubs() {
        return Database.getDatabase().getSubs();
    }
}
