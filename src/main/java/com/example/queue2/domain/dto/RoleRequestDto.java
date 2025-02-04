package com.example.queue2.domain.dto;

public record RoleRequestDto(String name, PageDto page) {

    public record PageDto(Long id, String name) {
    }
}