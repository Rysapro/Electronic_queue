package com.example.queue2.service;

import com.example.queue2.model.dto.PlaceOfCustomsClearanceDto;

import java.util.List;

public interface PlaceOfCustomClearanceService{
    PlaceOfCustomsClearanceDto save(PlaceOfCustomsClearanceDto placeOfCustomsClearanceDto);
    PlaceOfCustomsClearanceDto getById(Long id);
    List<PlaceOfCustomsClearanceDto> getAll();
}
