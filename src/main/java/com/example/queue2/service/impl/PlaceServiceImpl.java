package com.example.queue2.service.impl;

import com.example.queue2.domain.dto.PlaceResponseDto;
import com.example.queue2.domain.dto.PlaceRequestDto;
import com.example.queue2.domain.model.Place;
import com.example.queue2.repository.PlaceRepository;
import com.example.queue2.service.PlaceService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PlaceServiceImpl extends BaseServiceImpl<Place, PlaceRequestDto, PlaceResponseDto, PlaceRepository> implements PlaceService {

    public PlaceServiceImpl(PlaceRepository repo) {
        super(repo);

    }

    @Override
    public Place toEntity(PlaceRequestDto dto) {
        return new Place(dto.name(), dto.address(), dto.code());
    }

    @Override
    public PlaceResponseDto toDTO(Place entity) {
        return new PlaceResponseDto(entity.getId(), entity.getName(), entity.getAddress(), entity.getCode());
    }
}
