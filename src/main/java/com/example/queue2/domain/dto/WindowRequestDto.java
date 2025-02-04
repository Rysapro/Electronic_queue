package com.example.queue2.domain.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.example.queue2.domain.model.Window}
 */
public record WindowRequestDto(String number) implements Serializable {
}