package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.dto.PlaceRequestDto;
import com.example.queue2.domain.dto.PlaceResponseDto;
import com.example.queue2.domain.dto.PlaceTicketCountDto;
import com.example.queue2.domain.model.Place;
import com.example.queue2.service.PlaceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/place")
@Tag(name = "Место таможенного оформления")
public class PlaceController extends BaseController<Place, PlaceRequestDto, PlaceResponseDto, PlaceService> {
    private final PlaceService placeService;

    public PlaceController(PlaceService service) {
        super(service);
        this.placeService = service;
    }

    @GetMapping("/ticket-count")
    public List<PlaceTicketCountDto> getPending() {
        return placeService.getPending();
    }

    @Override
    protected String getBasePath() {
        return "place";
    }

    @Override
    protected PlaceRequestDto createEmptyDto() {
        return new PlaceRequestDto(null, null, null);
    }

    @GetMapping("/place-create")
    public String createForm(Model model) {
        model.addAttribute("form", createEmptyDto());
        return "place-create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("form") PlaceRequestDto model) {
        baseService.create(model);
        return "redirect:/place/place-list";
    }

    @GetMapping("/place-list")
    public String list(Model model) {
        List<PlaceResponseDto> allItems = baseService.findAll();
        model.addAttribute("items", allItems);
        return "place-list";
    }

    @GetMapping("/place-edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        PlaceResponseDto dto = baseService.findById(id);
        model.addAttribute("form", dto);
        return "place-edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("form") PlaceRequestDto model) {
        baseService.update(id, model);
        return "redirect:/place/place-list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        baseService.deleteById(id);
        return "redirect:/place/place-list";
    }
}