package com.example.queue2.domain.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.example.queue2.domain.model.Ticket}
 */
public record TicketResponseDto(Long id, Long number, PriorityDto priority, UserDto operatorId, PlaceDto place,
                                InformationDto information) implements Serializable {

    public record PriorityDto(Long id, String name) implements Serializable {
    }

    public record UserDto(Long id, String name) implements Serializable {
    }

    public record PlaceDto(Long id, String name) implements Serializable {
    }

    public record InformationDto(Long id, String declaration) implements Serializable {
    }
}