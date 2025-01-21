package com.example.queue2.service.impl;

import com.example.queue2.domain.model.Information;
import com.example.queue2.repository.InformationRepository;
import com.example.queue2.service.InformationService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class InformationServiceImpl extends BaseServiceImpl<Information, InformationRepository> implements InformationService {

    private final InformationRepository informationRepository;

    public InformationServiceImpl(InformationRepository informationRepository) {
        super(informationRepository);
        this.informationRepository = informationRepository;
    }
}
