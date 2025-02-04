package com.example.queue2.domain.model;

import com.example.queue2.domain.model.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne
    @JoinColumn(name = "provision_id")
    private Provision provision;

    public Place(String name, String address, Character code) {
        this.name = name;
        this.address = address;
        this.code = code;
    }

}
