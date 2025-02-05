package com.example.queue2.service.impl;

import com.example.queue2.domain.dto.ProvisionResponseDto;
import com.example.queue2.domain.dto.WindowRequestDto;
import com.example.queue2.domain.dto.WindowResponseDto;
import com.example.queue2.domain.model.Place;
import com.example.queue2.domain.model.User;
import com.example.queue2.domain.model.Window;
import com.example.queue2.repository.WindowRepository;
import com.example.queue2.service.WindowService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class WindowServiceImpl extends BaseServiceImpl<Window, WindowRequestDto, WindowResponseDto, WindowRepository> implements WindowService {

    public WindowServiceImpl(WindowRepository repo) {
        super(repo);
    }

    @Override
    public Window toEntity(WindowRequestDto dto) {
        Window window = new Window();
        window.setNumber(dto.number());
        window.setPlace(createEntityIfNotNull(
                dto.placeId(), id -> {
                    Place place = new Place();
                    place.setId(id);
                    return place;
                }
        ));
        window.setOperatorId(createEntityIfNotNull(
                dto.userId(), id -> {
                    User user = new User();
                    user.setId(id);
                    return user;
                }
        ));

        return window;

    }
    private <T> T createEntityIfNotNull(Long id, java.util.function.Function<Long, T> constructor) {
        return id != null ? constructor.apply(id) : null;}

    @Override
    public WindowResponseDto toDTO(Window entity) {
        return new WindowResponseDto(
                entity.getId(),
                entity.getNumber(),
                entity.getPlace() != null ? new WindowResponseDto.PlaceDto(
                        entity.getPlace().getId(),
                        entity.getPlace().getName()) : null,
                entity.getProcessedTicket() != null ? new WindowResponseDto.TicketDto(
                        entity.getProcessedTicket().getId(),
                        entity.getProcessedTicket().getNumber()) : null,
                entity.getOperatorId() != null ? new WindowResponseDto.UserDto(
                        entity.getOperatorId().getId(),
                        entity.getOperatorId().getName()) : null


        );
    }
}
