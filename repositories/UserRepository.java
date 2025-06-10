package com.example.planner.repositories;

import com.example.planner.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByUsername(String username);
    User findByUserName(String username);
}
