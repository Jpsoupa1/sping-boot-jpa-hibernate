package com.soupaproject.course.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soupaproject.course.entities.Category;
import com.soupaproject.course.service.CategoryService;


@RestController
@RequestMapping(value = "/categorys")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryServicee;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {

        List<Category> category = categoryServicee.findAll();
        return ResponseEntity.ok().body(category);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Optional<Category>> findById(@PathVariable Long id) {
        Optional<Category> category = categoryServicee.findByID(id);
        return ResponseEntity.ok().body(category);
    }
}
