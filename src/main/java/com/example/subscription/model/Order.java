package com.example.subscription.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int Id;
    private int amount;
    private int userId;
    private boolean valid;
    private String subscriptionType;
}
