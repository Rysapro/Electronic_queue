//package com.example.queue2.domain.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//@Entity
//public class PlaceOfCustomsClearance {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private String address;
//    private Character code;
//
//    public PlaceOfCustomsClearance() {
//    }
//
//    public PlaceOfCustomsClearance(String name, String address, Character code) {
//        this.name = name;
//        this.address = address;
//        this.code = code;
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
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public Character getCode() {
//        return code;
//    }
//
//    public void setCode(Character code) {
//        this.code = code;
//    }
//
//    @Override
//    public String toString() {
//        return "PlaceOfCustomsClearance{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", address='" + address + '\'' +
//                ", code=" + code +
//                '}';
//    }
//}
