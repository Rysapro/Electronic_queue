package com.example.queue2.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Window {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> processedTicket = new ArrayList<>();
    @OneToMany(mappedBy = "provision", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Provision> provision = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> operatorId = new ArrayList<>();
    @OneToMany(mappedBy = "placeOfCustomsClearance", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlaceOfCustomsClearance> placeOfCustomsClearances = new ArrayList<>();


}
