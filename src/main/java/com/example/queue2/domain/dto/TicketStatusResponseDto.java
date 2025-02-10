package com.example.queue2.domain.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.queue2.domain.model.TicketStatus}
 */
public record TicketStatusResponseDto(Long id, LocalDateTime createDate, String name) implements Serializable {
}