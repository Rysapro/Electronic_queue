package com.example.queue2.service.impl;

import com.example.queue2.model.Information;
import com.example.queue2.model.dto.InformationDto;
import com.example.queue2.repository.InformationRepository;
import com.example.queue2.service.InformationService;

import java.util.List;
import java.util.Optional;

public class InformationServiceImpl implements InformationService{

    private final InformationRepository informationRepository;

    public InformationServiceImpl(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }


    @Override
    public InformationDto saveInformation(InformationDto informationDto) {
        return informationRepository.save(informationDto);
    }

    @Override
    public Optional<InformationDto> getById(Long id) {
        return informationRepository.findById(id);
    }

    @Override
    public List<InformationDto> getAllUser() {
        return informationRepository.findAll();
    }
}
