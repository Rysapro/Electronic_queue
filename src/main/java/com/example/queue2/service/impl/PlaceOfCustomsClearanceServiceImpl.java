package com.example.queue2.service.impl;

import com.example.queue2.model.dto.PlaceOfCustomsClearanceDto;
import com.example.queue2.repository.PlaceOfCustomsClearanceRepository;
import com.example.queue2.service.PlaceOfCustomClearanceService;

import java.util.List;

public class PlaceOfCustomsClearanceServiceImpl implements PlaceOfCustomClearanceService {

    private final PlaceOfCustomsClearanceRepository placeOfCustomClearanceRepository;

    public PlaceOfCustomsClearanceServiceImpl(PlaceOfCustomsClearanceRepository placeOfCustomClearanceRepository) {
        this.placeOfCustomClearanceRepository = placeOfCustomClearanceRepository;
    }

    @Override
    public PlaceOfCustomsClearanceDto save(PlaceOfCustomsClearanceDto placeOfCustomsClearanceDto) {
        return placeOfCustomClearanceRepository.save(placeOfCustomsClearanceDto);
    }

    @Override
    public PlaceOfCustomsClearanceDto getById(Long id) {
        return placeOfCustomClearanceRepository.getReferenceById(id);
    }

    @Override
    public List<PlaceOfCustomsClearanceDto> getAll() {
        return placeOfCustomClearanceRepository.findAll();
    }



}
