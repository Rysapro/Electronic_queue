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

    @OneToMany
    private List<Priority> priority = new ArrayList<>();

    @OneToMany
    private List<User> updatedBy = new ArrayList<>();

    @OneToMany
    private List<User> operatorId = new ArrayList<>();

    @OneToMany
    private List <Place> place = new ArrayList<>();

    @OneToMany
    private List<Provision> provision = new ArrayList<>();

    @OneToMany
    private List<Information> information = new ArrayList<>();

}
