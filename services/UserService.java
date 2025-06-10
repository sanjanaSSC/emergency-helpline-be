package com.example.planner.services;

import com.example.planner.entities.User;
import com.example.planner.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
}
