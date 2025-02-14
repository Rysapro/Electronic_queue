package com.example.queue2.domain.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.example.queue2.domain.model.Ticket}
 */
public record TicketResponseDto(Long id, String number, PriorityDto priority, UserDto operatorId, PlaceDto place,
                                InformationDto information, ProvisionDto provision, TicketStatusDto ticketStatus) implements Serializable {

    public record PriorityDto(Long id, String name) implements Serializable {
    }

    public record UserDto(Long id, String name) implements Serializable {
    }

    public record PlaceDto(Long id, String name) implements Serializable {
    }

    public record InformationDto(Long id, String declaration) implements Serializable {
    }

    public record ProvisionDto(Long id, String name){
    }

    public record TicketStatusDto(Long id, String name){
    }
}