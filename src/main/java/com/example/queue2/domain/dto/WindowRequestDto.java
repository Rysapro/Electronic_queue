package com.example.queue2.domain.dto;

import com.example.queue2.domain.model.*;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Window}
 */
public record WindowRequestDto(String number, Long ticketId , Long placeId,
                               Long userId) implements Serializable {
}