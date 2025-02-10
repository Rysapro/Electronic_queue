package com.example.queue2.domain.dto;

import java.io.Serializable;

public record ProvisionResponseDto(Long id, String name, String code, PlaceDto place) implements Serializable {

    public record PlaceDto(Long id, String name) implements Serializable {
    }
}
