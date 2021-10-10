package com.example.subscription.repository;

import com.example.subscription.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubRepository extends JpaRepository <Subscription, Integer> {
}
