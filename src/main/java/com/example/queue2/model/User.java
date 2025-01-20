package com.example.queue2.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "placeOfCustomsClearance", cascade = CascadeType.ALL, orphanRemoval = true)
    private Queue<PlaceOfCustomsClearance> placeOfCustomsClearance = new LinkedList<>();
    private String name;
    private String surname;
    private String patronymic;
    private Boolean blocked;
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private Queue<Role> role = new LinkedList<>();



}
