package com.example.queue2.controller;

import com.example.queue2.domain.dto.PlaceResponseDto;
import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.dto.PlaceRequestDto;
import com.example.queue2.domain.model.Place;
import com.example.queue2.service.PlaceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/place")
@Tag(name = "Место таможенного оформления")
public class PlaceController extends BaseController<Place, PlaceRequestDto, PlaceResponseDto, PlaceService>{
    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        super(placeService);
        this.placeService = placeService;
    }
}
