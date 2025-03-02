package com.example.queue2.service.impl;

import com.example.queue2.domain.dto.PlaceResponseDto;
import com.example.queue2.domain.dto.PlaceRequestDto;
import com.example.queue2.domain.dto.PlaceTicketCountDto;
import com.example.queue2.domain.model.Place;
import com.example.queue2.domain.model.Ticket;
import com.example.queue2.repository.PlaceRepository;
import com.example.queue2.service.PlaceService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl extends BaseServiceImpl<Place, PlaceRequestDto, PlaceResponseDto, PlaceRepository> implements PlaceService {


    private final PlaceRepository placeRepository;

    public PlaceServiceImpl(PlaceRepository repo, PlaceRepository placeRepository) {
        super(repo);
        this.placeRepository = placeRepository;
    }

    @Override
    public Place toEntity(PlaceRequestDto dto) {
        return new Place(dto.name(), dto.address(), dto.code());
    }

    @Override
    public PlaceResponseDto toDTO(Place entity) {
        return new PlaceResponseDto(entity.getId(), entity.getPlaceName(), entity.getAddress(), entity.getCode());
    }

    public List<PlaceTicketCountDto> getPending(){
        return placeRepository.countActiveTicketsPerPlace();
    }


}
