package com.example.queue2.service;

import com.example.queue2.model.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto saveUser(UserDto userDto);
    Optional<UserDto> getUserById(Long id);
    List<UserDto> getAllUser();

}
