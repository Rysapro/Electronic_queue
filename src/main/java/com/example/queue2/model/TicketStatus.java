package com.example.queue2.model;

@Entity
public class TicketStatus {
    @Id
    @GeneratedValue(strategy = GeneratedType.IDENTITY)
    private Long id;
    private String name;
}
