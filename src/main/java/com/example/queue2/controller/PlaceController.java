package com.example.queue2.controller;

import com.example.queue2.domain.dto.PlaceResponseDto;
import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.dto.PlaceRequestDto;
import com.example.queue2.domain.dto.PlaceTicketCountDto;
import com.example.queue2.domain.model.Place;
import com.example.queue2.service.PlaceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/place")
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
}
