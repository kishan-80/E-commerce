package com.webApp.Ecommerce.service;

import com.webApp.Ecommerce.entity.User;
import com.webApp.Ecommerce.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User registerUser(User user) {
        return userRepo.save(user);
    }

    public User loginUser(String email, String password) {
        User found = userRepo.findByEmail(email);
        if(found != null && found.getPassword().equals(password)){
            return found;
        }
        return null;
    }

    public List<User> getAllUser() {
        return userRepo.findAll();
    }
}
