package com.example.springboot.controller;

import com.example.springboot.model.Order;
import com.example.springboot.model.TakeOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Controller
@RequestMapping("/")
public class OrderController {
   private final Order order = new Order();
    Session session = new Session();
    public static int id;

    @GetMapping()
    public String order(Model model) {
        order.setId(id);
        model.addAttribute("mod", order);
        model.addAttribute("orders", new TakeOrder());
        return "order";
    }
    @GetMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable("id") int id) {
        session.asyncDeleteOrder(id);
        return "redirect:/";
    }

    @PostMapping
    public CompletableFuture<String> processingOrder(Order takeOrder,TakeOrder take) {
        return session.asyncProcessOrder(takeOrder,take);
    }

    @ModelAttribute("models")
    public List<Order> getOrder() {
        return session.getList();
    }
}
