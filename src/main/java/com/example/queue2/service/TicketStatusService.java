package com.example.queue2.service;

import com.example.queue2.domain.dto.TicketStatusRequestDto;
import com.example.queue2.domain.dto.TicketStatusResponseDto;
import com.example.queue2.domain.model.TicketStatus;
import com.example.queue2.service.base.BaseService;

public interface TicketStatusService extends BaseService<TicketStatus, TicketStatusRequestDto, TicketStatusResponseDto> {
}
