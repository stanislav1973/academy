package com.example.springboot.controller;

import com.example.springboot.model.Order;
import com.example.springboot.model.TakeOrder;
import org.springframework.ui.Model;

public class Session extends Thread{
    Order order;
    TakeOrder takeOrder;
    String result;

    public Session(Order order, TakeOrder takeOrder,String result) {
        this.order = order;
        this.takeOrder = takeOrder;
        this.result = result;
    }

    @Override
    public void run() {
    }
}
