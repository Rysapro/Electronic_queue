package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.dto.TicketRequestDto;
import com.example.queue2.domain.dto.TicketResponseDto;
import com.example.queue2.domain.model.Ticket;
import com.example.queue2.service.TicketService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        return ticketCode;
    }

    @GetMapping("/page_ticket")
    public ResponseEntity<Page<TicketResponseDto>> getTickets(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(required = false) Long placeId,
            @RequestParam(required = false) Long informationId,
            @RequestParam(required = false) Long provisionId,
            @RequestParam(required = false) Long ticketStatusId

    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<TicketResponseDto> tickets = baseService.getTickets(placeId, informationId, provisionId, ticketStatusId, pageable);
        return ResponseEntity.ok(tickets);
    }

}
