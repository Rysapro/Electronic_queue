package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.dto.UserRequestDto;
import com.example.queue2.domain.dto.UserResponseDto;
import com.example.queue2.domain.model.User;
import com.example.queue2.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@Tag(name = "Пользователь")
public class UserController extends BaseController<User, UserRequestDto, UserResponseDto, UserService> {

    public UserController(UserService userService) {
        super(userService);
    }
}
