package com.example.queue2.domain.dto;

import java.io.Serializable;

public record RoleResponseDto(Long id, String name, PageDto page) implements Serializable {

    public record PageDto(Long id, String name) implements Serializable {
    }
}
