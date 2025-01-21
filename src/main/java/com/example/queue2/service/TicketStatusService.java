package com.example.queue2.service;

import com.example.queue2.model.dto.TicketStatusDto;

import java.util.List;
import java.util.Optional;

public interface TicketStatusService {
    TicketStatusDto save(TicketStatusDto ticketStatusDto);
    Optional<TicketStatusDto> getById(Long id);
    List<TicketStatusDto> getAll();
}
