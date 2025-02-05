package com.example.queue2.domain.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.example.queue2.domain.model.User}
 */
public record UserRequestDto(String name, String surname, String patronymic, Boolean blocked, Long placeId, Long roleId) implements Serializable {
}