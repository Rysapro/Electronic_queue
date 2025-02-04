package com.example.queue2.domain.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.example.queue2.domain.model.Place}
 */
public record PlaceRequestDto(String name, String address, Character code) implements Serializable {
}