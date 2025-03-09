package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.dto.OperatorTicketCountDto;
import com.example.queue2.domain.dto.TicketRequestDto;
import com.example.queue2.domain.dto.TicketResponseDto;
import com.example.queue2.domain.model.Ticket;
import com.example.queue2.service.TicketService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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
        Page<TicketResponseDto> tickets = baseService.getTickets(placeId, informationId,
                provisionId, ticketStatusId, pageable);
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/page_place_for_today")
    public ResponseEntity<Page<TicketResponseDto>> getPlace(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(required = false) Long placeId,
            @RequestParam(required = false) Long ticketStatusId
    ){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<TicketResponseDto> tickets = baseService.getPlaceId(placeId, ticketStatusId, pageable);
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/get_all_placeId")
    public List<TicketResponseDto> getAllPlace(
            @RequestParam Long placeId,
            @RequestParam Long ticketStatusId
    ){
        return baseService.getAllPlaceId(placeId, ticketStatusId);
    }

    @PutMapping("/update_status")
    public TicketResponseDto updateTicketStatus(Long id){
        return baseService.acceptanceTicket(id);
    }

    @PutMapping("/complete_ticket")
    public TicketResponseDto completeTicket(Long id){
        return baseService.completionTicket(id);
    }

    @PutMapping("/absence_ticket")
    public TicketResponseDto absenceTicket(Long id){
        return baseService.absenceTicket(id);
    }

    @PutMapping("/get_absence_ticket")
    public TicketResponseDto getAbsenceTicket(Long id){
        return baseService.getAbsenceTicket(id);
    }

    @GetMapping("/get_all_absence_ticket")
    public List<TicketResponseDto> getAllTicketStatusAbsence(Long placeId){
        return baseService.getAllTicketStatusAbsence(placeId);
    }

    @GetMapping("/page_ticket_finished")
    public ResponseEntity<Page<TicketResponseDto>> getTicketStatusEnded(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TicketResponseDto> tickets = baseService.getTicketStatusFinished(startDate, endDate, pageable);
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/page_ticket_finished_with_place")
    public ResponseEntity<Page<TicketResponseDto>> getTicketStatusEnded(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Long placeId,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TicketResponseDto> tickets = baseService.getTicketStatusFinishedWithPlace(placeId, startDate, endDate, pageable);
        return ResponseEntity.ok(tickets);
    }

  /*  @GetMapping("/operator_ticket_count")
    public ResponseEntity<List<OperatorTicketCountDto>> getCountTicketByUserId(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return ResponseEntity.ok(baseService.getCountTicketByUser(startDate, endDate));

    }*/

}
