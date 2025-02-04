package com.example.queue2.domain.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.queue2.domain.model.Priority}
 */
public record PriorityResponseDto(Long id, LocalDateTime createDate, String name,
                                  Long levelPriority) implements Serializable {
}