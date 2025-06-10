package com.example.planner.controllers;

import com.example.planner.entities.User;
import com.example.planner.services.UserDetailsServiceImpl;
import com.example.planner.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUpUser(@RequestBody User user){
        if(userService.existsByUsername(user.getName())){
            return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
        }
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>("User is successfully signed up", HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signInUser(@RequestBody User user){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
