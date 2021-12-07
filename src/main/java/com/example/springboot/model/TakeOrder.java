package com.example.springboot.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TakeOrder {
    private String numberOrder;
    private List<Order> list = new ArrayList<>();

}
