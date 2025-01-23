package com.example.queue2.domain.model;

import com.example.queue2.domain.model.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "page")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Page extends BaseEntity {

    @Column(name = "name", unique = true)
    private String name;

//    @ManyToMany(mappedBy = "page")
//    private List<Role> roles = new ArrayList<>();

}
