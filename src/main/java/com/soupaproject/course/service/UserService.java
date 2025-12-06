package com.soupaproject.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.soupaproject.course.entities.User;
import com.soupaproject.course.repository.UserRepository;
import com.soupaproject.course.service.exceptions.ControllerNotFoundException;
import com.soupaproject.course.service.exceptions.DatabaseException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }
    
//Conteiner object que pode ou nn conter um valor nulo (null)

    public User findByID(Long id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ControllerNotFoundException(id));
    }

    public User insert(User obj) {
        return repo.save(obj);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ControllerNotFoundException(id);
        }
        
        try {

            repo.deleteById(id);    
        
        } catch (DataIntegrityViolationException e) {

            throw new DatabaseException(e.getMessage());

        }

    }
 
    public User update(Long id,User obj) {

        try {

            User entity = repo.getReferenceById(id);
            updateData(entity, obj);            
            return repo.save(entity);

        } catch (EntityNotFoundException e) {

            throw new ControllerNotFoundException(id); 

        }

    }

    public void updateData(User entity,User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
    

}
