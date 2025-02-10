package com.example.queue2.domain.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.queue2.domain.model.Place}
 */
public record PlaceResponseDto(Long id, String name, String address, String code) implements Serializable {
}