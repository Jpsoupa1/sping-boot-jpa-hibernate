package com.soupaproject.course.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soupaproject.course.entities.Product;
import com.soupaproject.course.service.ProductService;


@RestController
@RequestMapping(value = "/products")
public class ProductController {
    
    @Autowired
    private ProductService productServicee;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {

        List<Product> product = productServicee.findAll();
        return ResponseEntity.ok().body(product);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable Long id) {
        Optional<Product> product = productServicee.findByID(id);
        return ResponseEntity.ok().body(product);
    }
}
