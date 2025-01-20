package com.example.queue2.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "placeOfCustomsClearance", cascade = CascadeType.ALL, orphanRemoval = true)
    private Queue<PlaceOfCustomsClearance> placeOfCustomsClearance = new LinkedList<>();
    private String name;
    private String surname;
    private String patronymic;
    private Boolean blocked;
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private Queue<Role> role = new LinkedList<>();

    public User() {
    }

    public User(Queue<PlaceOfCustomsClearance> placeOfCustomsClearance, String name, String surname, String patronymic, Boolean blocked, Queue<Role> role) {
        this.placeOfCustomsClearance = placeOfCustomsClearance;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.blocked = blocked;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Queue<PlaceOfCustomsClearance> getPlaceOfCustomsClearance() {
        return placeOfCustomsClearance;
    }

    public void setPlaceOfCustomsClearance(Queue<PlaceOfCustomsClearance> placeOfCustomsClearance) {
        this.placeOfCustomsClearance = placeOfCustomsClearance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public Queue<Role> getRole() {
        return role;
    }

    public void setRole(Queue<Role> role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", placeOfCustomsClearance=" + placeOfCustomsClearance +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", blocked=" + blocked +
                ", role=" + role +
                '}';
    }
}
