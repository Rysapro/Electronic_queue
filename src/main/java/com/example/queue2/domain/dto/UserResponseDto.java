package com.example.queue2.domain.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.example.queue2.domain.model.User}
 */
public record UserResponseDto(Long id, String name, String surname, String patronymic, String password, Boolean blocked, PlaceDto place, RoleDto role) implements Serializable {

    public record PlaceDto(Long id, String name) implements Serializable {
    }
    public record RoleDto(Long id, String name) implements Serializable {
    }
}