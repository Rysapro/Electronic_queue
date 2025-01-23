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
@Table(name = "provision")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Provision extends BaseEntity {

    @Column(name = "name", unique = true)
    private String name;

    @OneToMany
    private List<Place> place = new ArrayList<>();

    @Column(name = "code", unique = true)
    private Character code;


}
