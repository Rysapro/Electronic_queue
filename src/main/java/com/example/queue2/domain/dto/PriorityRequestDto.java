package com.example.queue2.domain.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.example.queue2.domain.model.Priority}
 */
public record PriorityRequestDto(String name, Long levelPriority) implements Serializable {
}