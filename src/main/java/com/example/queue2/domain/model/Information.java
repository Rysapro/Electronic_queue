package com.example.queue2.domain.model;

import com.example.queue2.domain.model.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Information extends BaseEntity {

    @Column(name = "declaration", unique = true)
    private String declaration;

}
