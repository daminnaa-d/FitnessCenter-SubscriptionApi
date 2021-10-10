package com.example.subscription.service;

import com.example.subscription.model.Subscription;

import java.util.List;

public interface SubscriptionService {

    List<Subscription> getAllSubs();
    void addSub( Subscription subscription);
}
