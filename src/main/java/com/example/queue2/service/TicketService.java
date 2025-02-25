package com.example.queue2.service;

import com.example.queue2.domain.dto.TicketRequestDto;
import com.example.queue2.domain.dto.TicketResponseDto;
import com.example.queue2.domain.model.Ticket;
import com.example.queue2.service.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TicketService extends BaseService<Ticket, TicketRequestDto, TicketResponseDto> {
    String generateTicket(Long placeId, Long provisionId);

    Ticket updateTicket(Ticket updatedTicket);

    void deleteTicketById(Long id);

    Page<TicketResponseDto> getTickets(Long placeId, Long informationId, Long provisionId,
                                       Long ticketStatusId, Pageable pageable);
    Page<TicketResponseDto> getPlaceId(Long placeId, Long ticketStatusId, Pageable pageable);

    List<TicketResponseDto> getAllPlaceId(Long placeId, Long ticketStatusId);

}
