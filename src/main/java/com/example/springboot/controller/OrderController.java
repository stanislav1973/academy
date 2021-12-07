package com.example.springboot.controller;

import com.example.springboot.model.Order;
import com.example.springboot.model.TakeOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class OrderController {
    Order order = new Order();
    TakeOrder tk = new TakeOrder();
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
        for (int i = tk.getList().size() - 1; i >=0 ; i--) {
            if (id == tk.getList().get(i).getId()){
                tk.getList().remove(tk.getList().get(i));
            }
        }
        return "redirect:/";
    }

    @PostMapping
    public String processingOrder(Order takeOrder,TakeOrder take) {
        String result = "redirect:/error";;
        if (take.getNumberOrder().equals("")) {
            tk.getList().add(takeOrder);
            takeOrder.setId(id);
            id++;
            result =  "redirect:/printOrder";
        } else {
                int k = Integer.parseInt(take.getNumberOrder());
                for (int i = tk.getList().size() - 1; i >= 0; i--) {
                    if (tk.getList().get(i).getId() == k) {
                        tk.getList().remove(tk.getList().get(i));
                        result =  "redirect:/printDeleteOrder";
                        break;
                    }
                }
        }
        return result;
    }

    @ModelAttribute("models")
    public List<Order> getOrder() {
        return tk.getList();
    }
}
