package com.example.queue2.service.impl;

import com.example.queue2.domain.model.Ticket;
import com.example.queue2.domain.model.User;
import com.example.queue2.repository.TicketRepository;
import com.example.queue2.repository.UserRepository;
import com.example.queue2.service.TicketService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl extends BaseServiceImpl<Ticket, TicketRepository> implements TicketService {
    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        super(ticketRepository);
        this.ticketRepository = ticketRepository;
    }


}
