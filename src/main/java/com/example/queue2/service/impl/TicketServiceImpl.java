package com.example.queue2.service.impl;

import com.example.queue2.domain.dto.TicketRequestDto;
import com.example.queue2.domain.dto.TicketResponseDto;
import com.example.queue2.domain.model.*;
import com.example.queue2.repository.PlaceRepository;
import com.example.queue2.repository.ProvisionRepository;
import com.example.queue2.repository.TicketRepository;
import com.example.queue2.repository.TicketStatusRepository;
import com.example.queue2.repository.base.BaseRepository;
import com.example.queue2.service.TicketService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl extends BaseServiceImpl<Ticket, TicketRequestDto, TicketResponseDto, TicketRepository> implements TicketService {

    private final PlaceRepository placeRepository;
    private final ProvisionRepository provisionRepository;
    private final TicketStatusRepository ticketStatusRepository;
    private final Counter counter;
    private final BaseRepository baseRepository;
    private final TicketRepository ticketRepository;


    public TicketServiceImpl(TicketRepository repo, PlaceRepository placeRepository, ProvisionRepository provisionRepository, TicketStatusRepository ticketStatusRepository, Counter counter, @Qualifier("baseRepository") BaseRepository baseRepository, TicketRepository ticketRepository) {
        super(repo);
        this.placeRepository = placeRepository;
        this.provisionRepository = provisionRepository;
        this.ticketStatusRepository = ticketStatusRepository;
        this.counter = counter;
        this.baseRepository = baseRepository;
        this.ticketRepository = ticketRepository;
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
                        entity.getInformation().getDeclaration()) : null,
                entity.getProvision() != null ? new TicketResponseDto.ProvisionDto(
                        entity.getProvision().getId(),
                        entity.getProvision().getProvisionName()) : null,
                entity.getTicketStatus() != null ? new TicketResponseDto.TicketStatusDto(
                        entity.getTicketStatus().getId(),
                        entity.getTicketStatus().getName()) : null

        );
    }

    public String generateTicket(Long placeId, Long provisionId){
        Place place = placeRepository.findById(placeId)
                .orElseThrow(() -> new RuntimeException("МТО не найдено"));
        Provision provision = provisionRepository.findById(provisionId)
                .orElseThrow(() -> new RuntimeException("Услуга не найдено"));
        TicketStatus status = ticketStatusRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Статус с ID 1 не найден"));

        int ticketNumber = counter.getNextNumber();
        String number = generateTicketCode(place.getCode(), provision.getProvisionName(), ticketNumber);

        Ticket ticket = new Ticket();
        ticket.setNumber(number);
        ticket.setPlace(place);
        ticket.setProvision(provision);
        ticket.setTicketStatus(status);

        repo.save(ticket);

        return number;
    }


    public String generateTicketCode(String code, String provisionName, int ticketNumber) {
        String lastTicketCode = repo.findMaxTicketCodeFor(code, provisionName);
        String numberPart = (lastTicketCode == null) ? "0" : lastTicketCode.replaceAll("\\D", "");
        int lastNumber = numberPart.isEmpty() ? 0 : Integer.parseInt(numberPart);

        return String.format("%s-%s-%04d", code, provisionName, ticketNumber);
    }

    //пагинация

    @Override
    public Page<TicketResponseDto> getTickets(Long placeId, Long informationId, Long provisionId,
                                              Long ticketStatusId, Pageable pageable) {
        if (placeId == null && informationId == null && provisionId == null && ticketStatusId == null){
            return Page.empty(pageable);

        } else {
            return ticketRepository.findAll(placeId, informationId, provisionId, ticketStatusId, pageable)
                    .map(this::mapToTicketResponseDto);
        }
    }



    public TicketResponseDto mapToTicketResponseDto(Ticket ticket){
        return new TicketResponseDto(
                ticket.getId(),
                ticket.getNumber(),
                null,
                null,
                ticket.getPlace() != null
                        ? new TicketResponseDto.PlaceDto(ticket.getPlace().getId(), ticket.getPlace().getPlaceName())
                        : null,
                ticket.getInformation() != null
                        ? new TicketResponseDto.InformationDto(ticket.getInformation().getId(), ticket.getInformation().getDeclaration())
                        : null,
                ticket.getProvision() != null
                        ? new TicketResponseDto.ProvisionDto(ticket.getProvision().getId(), ticket.getProvision().getProvisionName())
                        : null,
                ticket.getTicketStatus() != null
                        ? new TicketResponseDto.TicketStatusDto(ticket.getTicketStatus().getId(), ticket.getTicketStatus().getName())
                        : null
        );
    }

    //возвращает талоны со статусом pending по текущий день

    @Override
    public Page<TicketResponseDto> getPlaceId(Long placeId, Pageable pageable) {
        if(placeId == null){
            return Page.empty(pageable);
        } else{
            return ticketRepository.findPlace(placeId, pageable)
                    .map(this::mapToTicketResponseDto);
        }
    }



}
