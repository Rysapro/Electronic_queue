package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.dto.RoleRequestDto;
import com.example.queue2.domain.dto.RoleResponseDto;
import com.example.queue2.domain.model.Role;
import com.example.queue2.service.RoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
@Tag(name = "Роли")
public class RoleController extends BaseController<Role, RoleRequestDto, RoleResponseDto, RoleService> {

    public RoleController(RoleService roleService) {
        super(roleService);
    }
}
