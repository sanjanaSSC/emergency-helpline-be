package com.example.planner.entities;

import com.example.planner.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Name;
    private String contact;
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
