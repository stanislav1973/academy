package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/printDeleteOrder")
@Controller
public class PrintDeleteOrderController {
    @GetMapping()
    public String sentOrder(Model model) {
        return "/printDeleteOrder";
    }
}
