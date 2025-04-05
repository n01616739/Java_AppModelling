package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class ApiOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ObjectMapper objectMapper;  

    @PostMapping("/submit")
    public ResponseEntity<Order> placeOrderJson(@RequestBody String json) throws Exception {
        Order order = objectMapper.readValue(json, Order.class);  // JSON -> POJO
        Order saved = orderService.placeFullOrderFlow(order);
        return ResponseEntity.ok(saved);  // POJO -> JSON
    }
}
