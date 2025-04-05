package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderFormController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/place-order")
    public String showForm(HttpSession session, Model model) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        model.addAttribute("order", new Order());
        return "order-form";
    }

    @PostMapping("/submit-order")
    public String submitOrder(@ModelAttribute Order order, HttpSession session, Model model) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }

        // Call updated method from OrderService
        orderService.placeFullOrderFlow(order);

        model.addAttribute("order", new Order());
        model.addAttribute("message", "Order placed successfully and flow completed.");
        return "order-form";
    }
}
