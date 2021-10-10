package com.example.subscription.repository;

import com.example.subscription.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Integer> {
}
