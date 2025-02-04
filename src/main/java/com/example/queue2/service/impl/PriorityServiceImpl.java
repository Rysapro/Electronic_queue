package com.example.queue2.service.impl;

import com.example.queue2.domain.dto.PageResponseDto;
import com.example.queue2.domain.dto.PriorityRequestDto;
import com.example.queue2.domain.dto.PriorityResponseDto;
import com.example.queue2.domain.model.Priority;
import com.example.queue2.repository.PriorityRepository;
import com.example.queue2.service.PriorityService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PriorityServiceImpl extends BaseServiceImpl<Priority, PriorityRequestDto, PriorityResponseDto, PriorityRepository> implements PriorityService {



    public PriorityServiceImpl(PriorityRepository repo) {
        super(repo);

    }

    @Override
    public Priority toEntity(PriorityRequestDto dto) {
        return new Priority(dto.name(), dto.levelPriority());
    }

    @Override
    public PriorityResponseDto toDTO(Priority entity) {
        return new PriorityResponseDto(entity.getId(), entity.getCreateDate(), entity.getName(), entity.getLevelPriority());
    }
}