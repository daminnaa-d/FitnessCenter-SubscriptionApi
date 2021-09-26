package com.example.subscription.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int Id;
    private int amount;
    private int userId;
    private boolean valid;
    private List<String> subscriptionType;
}
