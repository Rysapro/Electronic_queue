package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.model.Ticket;
import com.example.queue2.service.TicketService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ticket")
@Tag(name = "билет")
public class TicketController extends BaseController<Ticket, TicketService> {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        super(ticketService);
        this.ticketService = ticketService;
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Ticket> updateTicket(
//            @PathVariable Long id,
//            @RequestBody Ticket ticket,
//            @RequestParam Long userId // The ID of the user making the request
//    ) {
//        // Call the service to update the ticket
//        Ticket updatedTicket = ticketService.updateTicket(id, ticket, userId);
//
//        // Return the updated ticket as a response
//        return ResponseEntity.ok(updatedTicket);
//    }
}
