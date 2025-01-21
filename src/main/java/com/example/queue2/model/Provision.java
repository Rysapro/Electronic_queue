package com.example.queue2.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Entity
public class Provision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "placeOfCustomsClearance", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlaceOfCustomsClearance> placeOfCustomsClearance = new ArrayList<>();
    private Character code;

}
