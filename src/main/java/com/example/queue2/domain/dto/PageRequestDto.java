package com.example.queue2.domain.dto;

import com.example.queue2.domain.model.PageForRole;

import java.io.Serializable;

/**
 * DTO for {@link PageForRole}
 */
public record PageRequestDto(String name) implements Serializable {
}