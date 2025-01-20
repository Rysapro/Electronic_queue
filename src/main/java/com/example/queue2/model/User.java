package com.example.queue2.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "placeOfCustomsClearence", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlaceOfCustomsClearance> placeOfCustomsClearance = new ArrayList<>();
    private String name;
    private String surname;
    private String patronymic;
    private Boolean blocked;
    private Long role;



}
