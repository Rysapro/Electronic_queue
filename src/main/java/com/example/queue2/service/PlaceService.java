package com.example.queue2.service;

import com.example.queue2.domain.dto.PlaceResponseDto;
import com.example.queue2.domain.dto.PlaceRequestDto;
import com.example.queue2.domain.dto.PlaceTicketCountDto;
import com.example.queue2.domain.model.Place;
import com.example.queue2.service.base.BaseService;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface PlaceService extends BaseService<Place, PlaceRequestDto, PlaceResponseDto> {
    List<PlaceTicketCountDto> getPending();
}
