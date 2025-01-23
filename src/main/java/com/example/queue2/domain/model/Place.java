package com.example.queue2.domain.model;

import com.example.queue2.domain.model.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "places")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Place extends BaseEntity {

    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "address", unique = true)
    private String address;
    @Column(name ="code", unique = true)
    private Character code;


}
