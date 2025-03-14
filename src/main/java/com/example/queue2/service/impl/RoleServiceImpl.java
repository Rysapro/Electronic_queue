package com.example.queue2.service.impl;

import com.example.queue2.domain.dto.RoleRequestDto;
import com.example.queue2.domain.dto.RoleResponseDto;
import com.example.queue2.domain.model.PageForRole;
import com.example.queue2.domain.model.Role;
import com.example.queue2.repository.RoleRepository;
import com.example.queue2.service.RoleService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleRequestDto, RoleResponseDto, RoleRepository> implements RoleService {

    public RoleServiceImpl(RoleRepository repo) {
        super(repo);
    }

    @Override
    public Role toEntity(RoleRequestDto dto) {
        Role role = new Role();
        role.setName(dto.name());
        role.setPage(Collections.singletonList(createEntityIfNotNull(
                dto.pageId(), id -> {
                    PageForRole page = new PageForRole();
                    page.setId(id);
                    return page;
                }
        )));

        return role;
    }
    private <T> T createEntityIfNotNull(Long id, java.util.function.Function<Long, T> constructor) {
        return id != null ? constructor.apply(id) : null;
    }

    @Override
    public RoleResponseDto toDTO(Role entity) {
        return new RoleResponseDto(
                entity.getId(),
                entity.getName(),
                entity.getPage().isEmpty()
                        ? null : new RoleResponseDto.PageDto(
                                entity.getPage().get(0).getId(),
                                entity.getPage().get(0).getName()
                )
        );
    }
}