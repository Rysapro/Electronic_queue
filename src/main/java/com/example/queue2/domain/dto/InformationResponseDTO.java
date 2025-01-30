package com.example.queue2.domain.dto;

import java.time.LocalDateTime;

public record InformationResponseDTO(Long id, String declaration, LocalDateTime createDate) {
}
