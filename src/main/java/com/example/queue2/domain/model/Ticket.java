package com.example.queue2.domain.model;

import com.example.queue2.domain.model.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends BaseEntity {

    private Timestamp timeOfCreateTicket;

    @Column(name = "quantity", unique = true)
    private Long number;

    private Timestamp timeOfFinished;
    private Timestamp processingTime;

    @ManyToOne
    @JoinColumn(name = "priority")
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "users")
    private User operatorId;

    @ManyToOne
    @JoinColumn(name = "place")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "info")
    private Information information;



}
