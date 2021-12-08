package com.example.springboot.controller;

import com.example.springboot.model.Order;
import com.example.springboot.model.TakeOrder;
import lombok.Data;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Data
@Service
public class Session {
    private List<Order> list = new ArrayList<>();
    @Async
    public CompletableFuture<String> asyncProcessOrder(Order takeOrder, TakeOrder take) {
        String result = "redirect:/error";
        if (take.getNumberOrder().equals("") && !takeOrder.getCity().equals("") && !takeOrder.getStreet().equals("")) {
            list.add(takeOrder);
            takeOrder.setId(OrderController.id);
            OrderController.id++;
            result =  "redirect:/printOrder";
        } else {
            int k = Integer.parseInt(take.getNumberOrder());
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i).getId() == k) {
                    list.remove(list.get(i));
                    result =  "redirect:/printDeleteOrder";
                    break;
                }
            }
        }
    return CompletableFuture.completedFuture(result);
    }
    @Async
    public void asyncDeleteOrder(int id) {
        for (int i = list.size() - 1; i >=0 ; i--) {
            if (id == list.get(i).getId()){
                list.remove(list.get(i));
            }
        }
    }
}
