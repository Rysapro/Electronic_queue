package com.example.queue2.service.impl;

import com.example.queue2.domain.model.TicketStatus;
import com.example.queue2.repository.TicketStatusRepository;
import com.example.queue2.service.TicketStatusService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class TicketStatusServiceImpl extends BaseServiceImpl<TicketStatus, TicketStatusRepository> implements TicketStatusService {

    private final TicketStatusRepository ticketStatusRepository;


    public TicketStatusServiceImpl(TicketStatusRepository ticketStatusRepository) {
        super(ticketStatusRepository);
        this.ticketStatusRepository = ticketStatusRepository;
    }
}
