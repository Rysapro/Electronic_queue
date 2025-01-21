//package com.example.queue2.domain.model;
//
//import jakarta.persistence.*;
//
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class Ticket {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private Timestamp timeOfCreateTicket;
//    private Long number;
//    @OneToMany(mappedBy = "placeOfCustomsClearance", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<TicketStatus> ticketStatusList = new ArrayList<>();
//    private Timestamp timeOfFinished;
//    private Timestamp processingTime;
//    @OneToMany(mappedBy = "priority", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Priority> priority = new ArrayList<>();
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<User> updatedBy = new ArrayList<>();
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<User> operatorId = new ArrayList<>();
//    @OneToMany(mappedBy = "placeOfCustomsClearance", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List <PlaceOfCustomsClearance> placeOfCustomsClearance = new ArrayList<>();
//    @OneToMany(mappedBy = "provision", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Provision> provision = new ArrayList<>();
//    private Long information;
//}
