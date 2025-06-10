package com.example.planner.services;

import com.example.planner.entities.User;
import com.example.planner.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(username);

        if(user!= null){
            UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                    .username(user.getName())
                    .password(user.getPassword())
                    .build();

            return userDetails;

        }
        throw new UsernameNotFoundException("User not found with username" + username);
    }
}
