package com.example.queue2.domain.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.example.queue2.domain.model.Place}
 */
public record PlaceRequestDto(String placeName, String address, String code) implements Serializable {
}