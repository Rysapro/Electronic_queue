package com.example.queue2.domain.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.example.queue2.domain.model.Window}
 */
public record WindowResponseDto(Long id, String number , PlaceDto place, TicketDto processedTicket,  UserDto operatorId) implements Serializable {

    public record PlaceDto(Long id, String name) implements Serializable {
    }
    public record TicketDto(Long id, String number) implements Serializable {
    }
    public record UserDto(Long id, String name) implements Serializable {
    }


}