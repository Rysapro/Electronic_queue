package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.dto.TicketRequestDto;
import com.example.queue2.domain.dto.TicketResponseDto;
import com.example.queue2.domain.dto.UserResponseDto;
import com.example.queue2.domain.model.Ticket;
import com.example.queue2.service.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ticket")
public class TicketController extends BaseController<Ticket, TicketRequestDto, TicketResponseDto, TicketService> {

    private final TicketService ticketService;
    private final PlaceService placeService;
    private final ProvisionService provisionService;
    private final InformationService informationService;
    private final TicketStatusService ticketStatusService;

    public TicketController(
            TicketService ticketService,
            PlaceService placeService,
            ProvisionService provisionService,
            InformationService informationService,
            TicketStatusService ticketStatusService
    ) {
        super(ticketService);
        this.ticketService = ticketService;
        this.placeService = placeService;
        this.provisionService = provisionService;
        this.informationService = informationService;
        this.ticketStatusService = ticketStatusService;
    }


    @Override
    protected String getBasePath() {
        return "ticket";
    }

    @Override
    protected TicketRequestDto createEmptyDto() {
        return new TicketRequestDto(null, null, null, null, null, null, null);
    }

    @GetMapping("/ticket-list-page")
    public String showList(
            Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(required = false) Long placeId,
            @RequestParam(required = false) Long informationId,
            @RequestParam(required = false) Long provisionId,
            @RequestParam(required = false) Long ticketStatusId
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<TicketResponseDto> tickets = ticketService.getTickets(
                placeId, informationId, provisionId, ticketStatusId, pageable
        );
        model.addAttribute("items", tickets.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", tickets.getTotalPages());
        model.addAttribute("totalItems", tickets.getTotalElements());
        return "ticket-list";
    }

    @GetMapping("/ticket-list")
    public String showList(Model model) {
        List<TicketResponseDto> allItems = baseService.findAll();
        model.addAttribute("items", allItems);
        return "ticket-list";
    }

    @GetMapping("/ticket-create")
    public String createForm(Model model) {
        model.addAttribute("form", createEmptyDto());
        model.addAttribute("provisions", provisionService.findAll());
        model.addAttribute("places", placeService.findAll());
        model.addAttribute("informations", informationService.findAll());
        model.addAttribute("ticketStatuses", ticketStatusService.findAll());
        return "ticket-create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("form") TicketRequestDto form) {
        baseService.create(form);
        return "redirect:/ticket/ticket-list";
    }

    @GetMapping("/ticket-edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        TicketResponseDto ticket = baseService.findById(id);
        model.addAttribute("form", ticket);
        model.addAttribute("places", placeService.findAll());
        model.addAttribute("provisions", provisionService.findAll());
        model.addAttribute("informations", informationService.findAll());
        model.addAttribute("ticketStatuses", ticketStatusService.findAll());
        return "ticket-edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("form") TicketRequestDto form) {
        System.out.println("asdfg"+form);
        baseService.update(id, form);
        return "redirect:/ticket/ticket-list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        baseService.deleteById(id);
        return "redirect:/ticket/ticket-list";
    }

    @GetMapping("/generate")
    public String generateTicket(
            @RequestParam Long placeId,
            @RequestParam Long provisionId
    ) {
        ticketService.generateTicket(placeId, provisionId);
        return "redirect:/ticket/ticket-list";
    }
}