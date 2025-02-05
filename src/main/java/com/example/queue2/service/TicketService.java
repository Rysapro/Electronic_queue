package com.example.queue2.service;

import com.example.queue2.domain.dto.TicketRequestDto;
import com.example.queue2.domain.dto.TicketResponseDto;
import com.example.queue2.domain.model.Ticket;
import com.example.queue2.service.base.BaseService;

public interface TicketService extends BaseService<Ticket, TicketRequestDto, TicketResponseDto> {
}
