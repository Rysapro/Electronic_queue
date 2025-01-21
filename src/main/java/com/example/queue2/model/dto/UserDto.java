package com.example.queue2.model.dto;

import com.example.queue2.model.PlaceOfCustomsClearance;

public record UserDto(Long id, String name, String username, String patronymic, Boolean blocked) {
}
