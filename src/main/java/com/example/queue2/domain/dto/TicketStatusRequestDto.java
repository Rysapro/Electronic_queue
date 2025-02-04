package com.example.queue2.domain.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.example.queue2.domain.model.TicketStatus}
 */
public record TicketStatusRequestDto(String name) implements Serializable {
}