package com.example.queue2.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tableName;
    private String operationType;
    private Long recordId;

    @OneToMany()
    private Long changeBy;
    private Timestamp changedTime;
}
