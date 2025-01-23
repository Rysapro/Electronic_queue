package com.example.queue2.domain.model;

import com.example.queue2.domain.model.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "priority")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Priority extends BaseEntity {

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "level", unique = true)
    private Long levelPriority;


}

