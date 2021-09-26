package com.example.subscription.db;

import com.example.subscription.model.Order;
import com.example.subscription.model.Subscription;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Database {
    private static Database database;
    private List<Subscription> subs = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    private Database(){
    }

    public static Database getDatabase(){
        if(database == null){
            database = new Database();
        }
        return database;
    }

}
