package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.dto.TicketRequestDto;
import com.example.queue2.domain.dto.TicketResponseDto;
import com.example.queue2.domain.model.Ticket;
import com.example.queue2.service.TicketService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController extends BaseController<Ticket, TicketRequestDto, TicketResponseDto, TicketService> {


    @Override
    protected String getBasePath() {
        return "";
    }

    @Override
    protected TicketRequestDto createEmptyDto() {
        return null;
    }

    public WebSocketController(TicketService service) {
        super(service);
    }

    @MessageMapping("/ticket")
    @SendTo("/topic/ticket")
    public String handleTicketEvent(TicketRequestDto requestDto) {
        String ticketCode = baseService.generateTicket(requestDto.placeId(), requestDto.provisionId());
        return "{\"response\" : \"" + ticketCode + "\"}";
    }

    @MessageMapping("/updateTicket")
    @SendTo("/topic/updateTicket")
    public Ticket handleUpdateTicketEvent(Ticket ticket) {
        System.out.println("Получено обновление тикета: " + ticket);
        return baseService.updateTicket(ticket);
    }

    @MessageMapping("/deleteTicket")
    @SendTo("/topic/ticket")
    public String handleDeleteTicketEvent(TicketResponseDto responseDto) {
        baseService.deleteTicketById(responseDto.id());
        return "{\"response\" : \"Билет удалён\"}";
    }
}
