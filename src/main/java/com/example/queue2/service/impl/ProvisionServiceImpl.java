package com.example.queue2.service.impl;

import com.example.queue2.domain.model.Provision;
import com.example.queue2.repository.ProvisionRepository;
import com.example.queue2.service.ProvisionService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProvisionServiceImpl extends BaseServiceImpl<Provision, ProvisionRepository> implements ProvisionService {
    private final ProvisionRepository provisionRepository;

    public ProvisionServiceImpl(ProvisionRepository provisionRepository) {
        super(provisionRepository);
        this.provisionRepository = provisionRepository;
    }

}

