package com.example.queue2.domain.model;

import com.example.queue2.domain.model.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "windows")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Window extends BaseEntity {

    @Column(name = "quantity", unique = true)
    private String number;

    @OneToMany
    private List<Ticket> processedTicket = new ArrayList<>();

    @OneToMany
    private List<Provision> provision = new ArrayList<>();

    @OneToMany
    private List<User> operatorId = new ArrayList<>();

    @OneToMany
    private List<Place> place = new ArrayList<>();
}
