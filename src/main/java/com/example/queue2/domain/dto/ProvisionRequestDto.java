package com.example.queue2.domain.dto;

public record ProvisionRequestDto (String name, Character code, PlaceDto place) {

    public record PlaceDto(Long id, String name, String address, Character code) {
    }
}
