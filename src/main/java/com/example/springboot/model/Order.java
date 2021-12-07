package com.example.springboot.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Order {

    private int id;
    private String city;
    private String street;
    private String numberHome;


}
