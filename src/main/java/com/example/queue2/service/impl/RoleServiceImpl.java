package com.example.queue2.service.impl;

import com.example.queue2.domain.model.Role;
import com.example.queue2.repository.RoleRepository;
import com.example.queue2.service.RoleService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleRepository> implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        super(roleRepository);
        this.roleRepository = roleRepository;
    }

}
