package com.example.queue2.controller;

import com.example.queue2.domain.dto.InformationRequestDTO;
import com.example.queue2.domain.dto.PlaceResponseDto;
import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.dto.PlaceRequestDto;
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
public class PlaceController extends BaseController<Place, PlaceRequestDto, PlaceResponseDto, PlaceService>{
    private final PlaceService placeService;

    public PlaceController(PlaceService placeService, PlaceService placeService1) {
        super(placeService);
        this.placeService = placeService1;
    }

    @GetMapping("/ticket-count")
    public List<PlaceTicketCountDto> getPending(){
        return placeService.getPending();
    }

    @Override
    @PostMapping("/save")
    public String save(@ModelAttribute("form") PlaceRequestDto model) {
        baseService.create(model);
        return "redirect:/place/list";
    }

    @Override
    protected String getBasePath() {
        return "";
    }

    @Override
    protected PlaceRequestDto createEmptyDto() {
        return null;
    }

    @Override
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("form", new PlaceRequestDto("","",""));
        return "place";

   }



}
