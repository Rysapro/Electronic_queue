package com.example.queue2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long placeOfCustomsClearance;
    private String tableName;
    private String operationType;
    private Boolean blocked;
    private Long role;
}
