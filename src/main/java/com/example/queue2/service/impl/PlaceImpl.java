package com.example.queue2.service.impl;

import com.example.queue2.domain.model.Place;
import com.example.queue2.repository.PlaceRepository;
import com.example.queue2.service.PlaceService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceImpl extends BaseServiceImpl<Place, PlaceRepository> implements PlaceService {
    private final PlaceRepository placeRepository;

    public PlaceImpl(PlaceRepository placeRepository) {
        super(placeRepository);
        this.placeRepository = placeRepository;
    }
}
