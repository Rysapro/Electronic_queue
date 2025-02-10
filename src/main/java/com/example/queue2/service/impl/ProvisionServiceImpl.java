package com.example.queue2.service.impl;

import com.example.queue2.domain.dto.ProvisionRequestDto;
import com.example.queue2.domain.dto.ProvisionResponseDto;
import com.example.queue2.domain.dto.RoleResponseDto;
import com.example.queue2.domain.model.Place;
import com.example.queue2.domain.model.Provision;
import com.example.queue2.repository.ProvisionRepository;
import com.example.queue2.service.ProvisionService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProvisionServiceImpl extends BaseServiceImpl<Provision, ProvisionRequestDto, ProvisionResponseDto, ProvisionRepository> implements ProvisionService {

    public ProvisionServiceImpl(ProvisionRepository repo) {
        super(repo);
    }

    @Override
    public Provision toEntity(ProvisionRequestDto dto) {
        Provision provision = new Provision();
        provision.setCode(dto.code());
        provision.setProvisionName(dto.name());
        provision.setPlace(createEntityIfNotNull(
                dto.placeId(), id ->  {
                    Place place = new Place();
                    place.setId(id);
                    return place;
                }
        ));

        return provision;
    }
    private <T> T createEntityIfNotNull(Long id, java.util.function.Function<Long, T> constructor) {
        return id != null ? constructor.apply(id) : null;}

    @Override
    public ProvisionResponseDto toDTO(Provision entity) {
        return new ProvisionResponseDto(
                entity.getId(),
                entity.getProvisionName(),
                entity.getCode(),
                entity.getPlace() != null
                        ? new ProvisionResponseDto.PlaceDto(
                                entity.getPlace().getId(),
                                entity.getPlace().getPlaceName()) : null
        );
    }
}

