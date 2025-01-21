package com.example.queue2.service;

import com.example.queue2.model.Information;
import com.example.queue2.model.dto.InformationDto;

import java.util.List;
import java.util.Optional;

public interface InformationService {
    InformationDto saveInformation(InformationDto informationDto);
    Optional<InformationDto> getById(Long id);
    List<InformationDto> getAllUser();
}
