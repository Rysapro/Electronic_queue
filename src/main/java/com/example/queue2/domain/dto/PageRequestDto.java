package com.example.queue2.domain.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.example.queue2.domain.model.Page}
 */
public record PageRequestDto(String name) implements Serializable {
}