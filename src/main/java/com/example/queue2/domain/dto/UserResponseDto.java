package com.example.queue2.domain.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.example.queue2.domain.model.User}
 */
public record UserResponseDto(Long id, String name, String surname, Boolean blocked, PlaceDto place) implements Serializable {

    public record PlaceDto(Long id, String name) implements Serializable {
    }
}