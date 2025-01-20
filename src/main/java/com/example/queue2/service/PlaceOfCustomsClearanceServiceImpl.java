package com.example.queue2.service;

import com.example.queue2.model.dto.PlaceOfCustomsClearanceDto;
import com.example.queue2.repository.PlaceOfCustomClearanceRepository;

public class PlaceOfCustomsClearanceServiceImpl implements PlaceOfCustomClearanceService{

    private final PlaceOfCustomClearanceRepository placeOfCustomClearanceRepository;

    public PlaceOfCustomsClearanceServiceImpl(PlaceOfCustomClearanceRepository placeOfCustomClearanceRepository) {
        this.placeOfCustomClearanceRepository = placeOfCustomClearanceRepository;
    }

    @Override
    public PlaceOfCustomsClearanceDto save(PlaceOfCustomsClearanceDto placeOfCustomsClearanceDto) {
        return placeOfCustomClearanceRepository.save(placeOfCustomsClearanceDto);
    }
}
