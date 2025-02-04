package com.example.queue2.service.impl;

import com.example.queue2.domain.dto.TicketStatusRequestDto;
import com.example.queue2.domain.dto.TicketStatusResponseDto;
import com.example.queue2.domain.model.TicketStatus;
import com.example.queue2.repository.TicketStatusRepository;
import com.example.queue2.service.TicketStatusService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class TicketStatusServiceImpl extends BaseServiceImpl<TicketStatus, TicketStatusRequestDto, TicketStatusResponseDto, TicketStatusRepository> implements TicketStatusService {

    public TicketStatusServiceImpl(TicketStatusRepository repo) {
        super(repo);
    }

    @Override
    public TicketStatus toEntity(TicketStatusRequestDto dto) {
        return new TicketStatus(dto.name());
    }

    @Override
    public TicketStatusResponseDto toDTO(TicketStatus entity) {
        return new TicketStatusResponseDto(entity.getId(), entity.getCreateDate(), entity.getName());
    }
}
