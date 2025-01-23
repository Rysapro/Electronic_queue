package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.model.TicketStatus;
import com.example.queue2.service.TicketStatusService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ticket-status")
@Tag(name="Статус о биллете")
public class TicketStatusController extends BaseController<TicketStatus, TicketStatusService> {
    private final TicketStatusService ticketStatusService;

    public TicketStatusController(TicketStatusService ticketStatusService) {
        super(ticketStatusService);
        this.ticketStatusService = ticketStatusService;
    }
}
