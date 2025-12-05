package com.soupaproject.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soupaproject.course.entities.Category;
import com.soupaproject.course.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repo;

    public List<Category> findAll() {
        return repo.findAll();
    }
    
//Conteiner object que pode ou nn conter um valor nulo (null)

    public Optional<Category> findByID(Long id) {
        return repo.findById(id);
    }
    
}
