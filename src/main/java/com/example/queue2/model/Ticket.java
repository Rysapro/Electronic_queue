package com.example.queue2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp timeOfCreateTicket;
    private Long number;
    @OneToMany(mappedBy = "placeOfCustomsClearence", cascade = CascadeType.ALL, orphanRemoval = true)
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
