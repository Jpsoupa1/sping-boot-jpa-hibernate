package com.soupaproject.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soupaproject.course.entities.Order;
import com.soupaproject.course.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repo;

    public List<Order> findAll() {
        return repo.findAll();
    }
    
//Conteiner object que pode ou nn conter um valor nulo (null)

    public Optional<Order> findByID(Long id) {
        return repo.findById(id);
    }
    
}
