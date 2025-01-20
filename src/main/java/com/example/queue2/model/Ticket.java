package com.example.queue2.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp timeOfCreateTicket;
    private Long number;
    @OneToMany(mappedBy = "placeOfCustomsClearance", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TicketStatus> ticketStatusList = new ArrayList<>();
    private Timestamp timeOfFinished;
    private Timestamp processingTime;
    private Long priority;
    private Long updated_by;
    private Long operator_id;
    private Long placeOfCustomsClearance;
    private Long provision;
    private Long information;
}
