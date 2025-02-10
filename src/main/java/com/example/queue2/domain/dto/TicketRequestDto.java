package com.example.queue2.domain.dto;

import com.example.queue2.domain.model.Information;
import com.example.queue2.domain.model.Place;
import com.example.queue2.domain.model.Priority;
import com.example.queue2.domain.model.User;

import java.io.Serializable;

/**
 * DTO for {@link com.example.queue2.domain.model.Ticket}
 */
public record TicketRequestDto(Long number, Long priorityId, Long userId , Long placeId, Long provisionId,
                               Long informationId) implements Serializable {
}