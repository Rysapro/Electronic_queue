package com.example.queue2.service.impl;

import com.example.queue2.domain.dto.PriorityDto;
import com.example.queue2.domain.model.Priority;
import com.example.queue2.repository.PriorityRepository;
import com.example.queue2.service.PriorityService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PriorityServiceImpl extends BaseServiceImpl<Priority, PriorityRepository> implements PriorityService {

    private final PriorityRepository priorityRepository;

    public PriorityServiceImpl(PriorityRepository priorityRepository) {
        super(priorityRepository);
        this.priorityRepository = priorityRepository;
    }

}