package com.example.queue2.service.impl;

import com.example.queue2.domain.dto.TicketRequestDto;
import com.example.queue2.domain.dto.TicketResponseDto;
import com.example.queue2.domain.model.*;
import com.example.queue2.repository.PlaceRepository;
import com.example.queue2.repository.ProvisionRepository;
import com.example.queue2.repository.TicketRepository;
import com.example.queue2.repository.TicketStatusRepository;
import com.example.queue2.service.TicketService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TicketServiceImpl extends BaseServiceImpl<Ticket, TicketRequestDto, TicketResponseDto, TicketRepository> implements TicketService {

    private final PlaceRepository placeRepository;
    private final ProvisionRepository provisionRepository;
    private final TicketStatusRepository ticketStatusRepository;

    public TicketServiceImpl(TicketRepository repo, PlaceRepository placeRepository, ProvisionRepository provisionRepository, TicketStatusRepository ticketStatusRepository) {
        super(repo);
        this.placeRepository = placeRepository;
        this.provisionRepository = provisionRepository;
        this.ticketStatusRepository = ticketStatusRepository;
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
                        entity.getPlace().getPlaceName()) : null,
                entity.getInformation() != null ? new TicketResponseDto.InformationDto(
                        entity.getInformation().getId(),
                        entity.getInformation().getDeclaration()) : null

        );
    }

    public String generateTicket(Long placeId, Long provisionId){
        Place place = placeRepository.findById(placeId)
                .orElseThrow(() -> new RuntimeException("МТО не найдено"));
        Provision provision = provisionRepository.findById(provisionId)
                .orElseThrow(() -> new RuntimeException("Услуга не найдено"));
        TicketStatus status = ticketStatusRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Статус с ID 1 не найден"));

        String ticketCode = generateTicketCode(place.getPlaceName(), provision.getProvisionName());

        Ticket ticket = new Ticket();
        ticket.setTicketCode(ticketCode);
        ticket.setPlace(place);
        ticket.setProvision(provision);
        ticket.setTicketStatus(status);

        repo.save(ticket);

        return ticketCode;
    }

    private String generateTicketCode(String placeName, String provisionName) {
        String lastTicketCode = repo.findMaxTicketCodeFor(placeName, provisionName);
        String numberPart = (lastTicketCode == null) ? "0" : lastTicketCode.replaceAll("\\D", "");
        int lastNumber = numberPart.isEmpty() ? 0 : Integer.parseInt(numberPart);

        int newTicketNumber = lastNumber + 1;
        return String.format("%s-%s-%04d", placeName, provisionName, newTicketNumber);
    }


}
