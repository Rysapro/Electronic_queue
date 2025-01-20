package com.example.queue2.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp timeOfCreateTicket;
    private Long number;
    @OneToMany(mappedBy = "placeOfCustomsClearance", cascade = CascadeType.ALL, orphanRemoval = true)
    private Queue<TicketStatus> ticketStatusList = new LinkedList<>();
    private Timestamp timeOfFinished;
    private Timestamp processingTime;
    @OneToMany(mappedBy = "priority", cascade = CascadeType.ALL, orphanRemoval = true)
    private Queue<Priority> priority = new LinkedList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Queue<User> updatedBy = new LinkedList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Queue<User> operatorId = new LinkedList<>();
    @OneToMany(mappedBy = "placeOfCustomsClearance", cascade = CascadeType.ALL, orphanRemoval = true)
    private Queue <PlaceOfCustomsClearance> placeOfCustomsClearance = new LinkedList<>();
    @OneToMany(mappedBy = "provision", cascade = CascadeType.ALL, orphanRemoval = true)
    private Queue<Provision> provision = new LinkedList<>();
    private Long information;
}
