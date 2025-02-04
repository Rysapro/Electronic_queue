package com.example.queue2.service.impl;

import com.example.queue2.domain.dto.ProvisionRequestDto;
import com.example.queue2.domain.dto.ProvisionResponseDto;
import com.example.queue2.domain.model.Place;
import com.example.queue2.domain.model.Provision;
import com.example.queue2.repository.ProvisionRepository;
import com.example.queue2.service.ProvisionService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvisionServiceImpl extends BaseServiceImpl<Provision, ProvisionRequestDto, ProvisionResponseDto, ProvisionRepository> implements ProvisionService {

    public ProvisionServiceImpl(ProvisionRepository repo) {
        super(repo);
    }

    @Override
    public Provision toEntity(ProvisionRequestDto dto) {
        return new Provision(dto.name(), dto.code(), List.of(new Place(dto.place().name(), dto.place().address(), dto.place().code())));
    }

    @Override
    public ProvisionResponseDto toDTO(Provision entity) {

        return new ProvisionResponseDto(entity.getId(), entity.getName(),
                entity.getCode(), entity.getPlace().isEmpty() ? null : new ProvisionResponseDto.PlaceDto(entity.getPlace().get(0).getId(),
                entity.getPlace().get(0).getName(), entity.getPlace().get(0).getAddress(), entity.getPlace().get(0).getCode()));
    }
}

