package com.soupaproject.course.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soupaproject.course.entities.Order;
import com.soupaproject.course.service.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {

        List<Order> orders = orderService.findAll();
        return ResponseEntity.ok().body(orders);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Optional<Order>> findById(@PathVariable Long id) {
        Optional<Order> order = orderService.findByID(id);
        return ResponseEntity.ok().body(order);
    }
}
