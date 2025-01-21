//package com.example.queue2.domain.model;
//
//import jakarta.persistence.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @OneToMany(mappedBy = "placeOfCustomsClearance", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<PlaceOfCustomsClearance> placeOfCustomsClearance = new ArrayList<>();
//    private String name;
//    private String surname;
//    private String patronymic;
//    private Boolean blocked;
//    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Role> role = new ArrayList<>();
//
//    public User() {
//    }
//
//    public User(List<PlaceOfCustomsClearance> placeOfCustomsClearance, String name, String surname, String patronymic, Boolean blocked, List<Role> role) {
//        this.placeOfCustomsClearance = placeOfCustomsClearance;
//        this.name = name;
//        this.surname = surname;
//        this.patronymic = patronymic;
//        this.blocked = blocked;
//        this.role = role;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public List<PlaceOfCustomsClearance> getPlaceOfCustomsClearance() {
//        return placeOfCustomsClearance;
//    }
//
//    public void setPlaceOfCustomsClearance(List<PlaceOfCustomsClearance> placeOfCustomsClearance) {
//        this.placeOfCustomsClearance = placeOfCustomsClearance;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public String getPatronymic() {
//        return patronymic;
//    }
//
//    public void setPatronymic(String patronymic) {
//        this.patronymic = patronymic;
//    }
//
//    public Boolean getBlocked() {
//        return blocked;
//    }
//
//    public void setBlocked(Boolean blocked) {
//        this.blocked = blocked;
//    }
//
//    public List<Role> getRole() {
//        return role;
//    }
//
//    public void setRole(List<Role> role) {
//        this.role = role;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", placeOfCustomsClearance=" + placeOfCustomsClearance +
//                ", name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", patronymic='" + patronymic + '\'' +
//                ", blocked=" + blocked +
//                ", role=" + role +
//                '}';
//    }
//}
