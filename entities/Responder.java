package com.example.planner.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Responder extends User{
    @OneToMany(mappedBy = "responder")
    private List<AnimalReport> assignedReports = new ArrayList<>();

    private boolean avaliable;
}
