package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.dto.TicketRequestDto;
import com.example.queue2.domain.dto.TicketResponseDto;
import com.example.queue2.domain.model.Ticket;
import com.example.queue2.service.TicketService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ticket")
@Tag(name = "билет")
public class TicketController extends BaseController<Ticket, TicketRequestDto, TicketResponseDto, TicketService> {

    public TicketController(TicketService ticketService) {
        super(ticketService);
    }

    @PostMapping("/gen_code")
    public String createTicketCode(@RequestParam Long placeId, @RequestParam Long provisionId){
        String ticketCode = String.valueOf(baseService.generateTicket(placeId, provisionId));
        return ticketCode;   }


}
