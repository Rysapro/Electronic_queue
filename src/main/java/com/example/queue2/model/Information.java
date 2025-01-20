package com.example.queue2.model;

@Entity
public class Information {
    @Id
    @GeneratedValue(strategy = GeneratedType.IDENTITY)
    private Long id;
    private String declaretion;
}
