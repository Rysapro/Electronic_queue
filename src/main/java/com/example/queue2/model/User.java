package com.example.queue2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long placeOfCustomsClearence;
    private String name;
    private String surname;
    private String patronymic;
    private Boolean blocked;
    private Long role;



}
