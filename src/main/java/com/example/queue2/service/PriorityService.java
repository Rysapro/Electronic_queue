package com.example.queue2.service;

import com.example.queue2.model.dto.PriorityDto;

import java.util.List;
import java.util.Optional;

public interface PriorityService {
    PriorityDto save(PriorityDto priorityDto);
    Optional<PriorityDto> getById(Long id);
    List<PriorityDto> getAll();
}
