package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PrintOrderController {
    @GetMapping("/printOrder")
    public String sentOrder(Model model) {
        model.addAttribute("print", new OrderController());
        return "/printOrder";
    }
}
