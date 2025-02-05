package com.example.queue2.service.impl;

import com.example.queue2.domain.dto.TicketRequestDto;
import com.example.queue2.domain.dto.TicketResponseDto;
import com.example.queue2.domain.model.*;
import com.example.queue2.repository.TicketRepository;
import com.example.queue2.service.TicketService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class TicketServiceImpl extends BaseServiceImpl<Ticket, TicketRequestDto, TicketResponseDto, TicketRepository> implements TicketService {

    public TicketServiceImpl(TicketRepository repo) {
        super(repo);
    }


    @Override
    public Ticket toEntity(TicketRequestDto dto) {
        Ticket ticket = new Ticket();
        ticket.setNumber(dto.number());
        ticket.setPriority(createEntityIfNotNull(
                dto.priorityId(), id -> {
                    Priority priority = new Priority();
                    priority.setId(id);
                    return priority;
                }
        ));
        ticket.setOperatorId(createEntityIfNotNull(
                dto.userId(), id -> {
                    User user = new User();
                    user.setId(id);
                    return user;
                }
        ));
        ticket.setPlace(createEntityIfNotNull(
                dto.placeId(), id -> {
                    Place place = new Place();
                    place.setId(id);
                    return place;
                }
        ));
        ticket.setInformation(createEntityIfNotNull(
                dto.informationId(), id -> {
                    Information information = new Information();
                    information.setId(id);
                    return information;
                }
        ));
        return ticket;
    }
    private <T> T createEntityIfNotNull(Long id, java.util.function.Function<Long, T> constructor) {
        return id != null ? constructor.apply(id) : null;}


    @Override
    public TicketResponseDto toDTO(Ticket entity) {
        return new TicketResponseDto(
                entity.getId(),
                entity.getNumber(),
                entity.getPriority() != null ? new TicketResponseDto.PriorityDto(
                        entity.getPriority().getId(),
                        entity.getPriority().getName()) : null,
                entity.getOperatorId() != null ? new TicketResponseDto.UserDto(
                        entity.getOperatorId().getId(),
                        entity.getOperatorId().getName()) : null,
                entity.getPlace() != null ? new TicketResponseDto.PlaceDto(
                        entity.getPlace().getId(),
                        entity.getPlace().getName()) : null,
                entity.getInformation() != null ? new TicketResponseDto.InformationDto(
                        entity.getInformation().getId(),
                        entity.getInformation().getDeclaration()) : null

        );
    }
}
