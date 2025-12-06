package com.soupaproject.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soupaproject.course.entities.User;
import com.soupaproject.course.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }
    
//Conteiner object que pode ou nn conter um valor nulo (null)

    public Optional<User> findByID(Long id) {
        return repo.findById(id);
    }

    public User insert(User obj) {
        return repo.save(obj);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
    
}
