package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.dto.TicketStatusRequestDto;
import com.example.queue2.domain.dto.TicketStatusResponseDto;
import com.example.queue2.domain.model.TicketStatus;
import com.example.queue2.service.TicketStatusService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/status")
@Tag(name="Статус талона")
public class TicketStatusController extends BaseController<TicketStatus, TicketStatusRequestDto, TicketStatusResponseDto, TicketStatusService> {

    @Override
    protected String getBasePath() {
        return "status";
    }

    @Override
    protected TicketStatusRequestDto createEmptyDto() {
        return new TicketStatusRequestDto(null);
    }

    public TicketStatusController(TicketStatusService ticketStatusService) {
        super(ticketStatusService);
    }

    @Override
    @GetMapping("/status-create")
    public String createForm(Model model) {
        model.addAttribute("form", createEmptyDto());
        return "status-create";
    }

    @Override
    @PostMapping("/save")
    public String save(@ModelAttribute("form") TicketStatusRequestDto model) {
        baseService.create(model);
        return "redirect:/status/status-list";
    }

    @Override
    @GetMapping("/status-list")
    public String list(Model model) {
        List<TicketStatusResponseDto> allItems = baseService.findAll();
        model.addAttribute("items", allItems);
        return "status-list";
    }

    @GetMapping("/status-edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("form", baseService.findById(id));
        return "status-edit";
    }


    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("form") TicketStatusRequestDto model) {
        baseService.update(id, model);
        return "redirect:/status/status-list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        baseService.deleteById(id);
        return "redirect:/status/status-list";
    }
}
