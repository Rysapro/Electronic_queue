package com.example.queue2.service.impl;

import com.example.queue2.domain.dto.OperatorTicketCountDto;
import com.example.queue2.domain.dto.PlaceTicketCountDto;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl extends BaseServiceImpl<Ticket, TicketRequestDto, TicketResponseDto, TicketRepository> implements TicketService {

    private final PlaceRepository placeRepository;
    private final ProvisionRepository provisionRepository;
    private final TicketStatusRepository ticketStatusRepository;
    private final Counter counter;
    private final BaseRepository baseRepository;
    private final TicketRepository ticketRepository;


    public TicketServiceImpl(TicketRepository repo, PlaceRepository placeRepository, ProvisionRepository provisionRepository, TicketStatusRepository ticketStatusRepository, Counter counter, @Qualifier("baseRepository") BaseRepository baseRepository, TicketRepository ticketRepository, ScheduledTaskService scheduledTaskService) {
        super(repo);
        this.placeRepository = placeRepository;
        this.provisionRepository = provisionRepository;
        this.ticketStatusRepository = ticketStatusRepository;
        this.counter = counter;
        this.baseRepository = baseRepository;
        this.ticketRepository = ticketRepository;
        this.scheduledTaskService = scheduledTaskService;
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
        return id != null ? constructor.apply(id) : null;
    }


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

    public String generateTicket(Long placeId, Long provisionId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) auth.getPrincipal();

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
        ticket.setOperatorId(currentUser);

        repo.save(ticket);

        return number;
    }


    public String generateTicketCode(String code, String provisionName, int ticketNumber) {
        String lastTicketCode = repo.findMaxTicketCodeFor(code, provisionName);
        String numberPart = (lastTicketCode == null) ? "0" : lastTicketCode.replaceAll("\\D", "");
        int lastNumber = numberPart.isEmpty() ? 0 : Integer.parseInt(numberPart);

        return String.format("%s-%s-%04d", code, provisionName, ticketNumber);
    }

    @Override
    public Ticket updateTicket(Ticket updatedTicket) {
        Ticket ticket = repo.findById(updatedTicket.getId())
                .orElseThrow(() -> new RuntimeException("Билет не найден!!!"));

        if (updatedTicket.getPlace() != null) {
            ticket.setPlace(updatedTicket.getPlace());
        }

        if (updatedTicket.getProvision() != null) {
            ticket.setProvision(updatedTicket.getProvision());
        }

        if (updatedTicket.getTicketStatus() != null) {
            ticket.setTicketStatus(updatedTicket.getTicketStatus());
        }

        repo.save(ticket);
        return ticket;
    }

    @Override
    public void deleteTicketById(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Билет не найден!");
        }
        repo.deleteById(id);
    }

    //Пагинация

    @Override
    public Page<TicketResponseDto> getTickets(Long placeId, Long informationId, Long provisionId,
                                              Long ticketStatusId, Pageable pageable) {
        if (placeId == null && informationId == null && provisionId == null && ticketStatusId == null) {
            return Page.empty(pageable);

        } else {
            return ticketRepository.findAll(placeId, informationId, provisionId, ticketStatusId, pageable)
                    .map(this::mapToTicketResponseDto);
        }
    }


    public TicketResponseDto mapToTicketResponseDto(Ticket ticket) {
        return new TicketResponseDto(
                ticket.getId(),
                ticket.getNumber(),
                ticket.getPriority() != null
                        ? new TicketResponseDto.PriorityDto(ticket.getId(), ticket.getPriority().getName())
                        : null,
                ticket.getOperatorId() != null
                        ? new TicketResponseDto.UserDto(ticket.getId(), ticket.getOperatorId().getName())
                        : null,
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
    public Page<TicketResponseDto> getPlaceId(Long placeId, Long ticketStatusId, Pageable pageable) {
        if (placeId == null && ticketStatusId == null) {
            return Page.empty(pageable);
        } else {
            return ticketRepository.findPlace(placeId, ticketStatusId, pageable)
                    .map(this::mapToTicketResponseDto);
        }
    }


    //возврат всех талонов по placeId со статусом горит
    @Override
    public List<TicketResponseDto> getAllPlaceId(Long placeId, Long ticketStatusId) {
        return ticketRepository.findByPlaceId(placeId, ticketStatusId)
                .stream()
                .map(this::mapToTicketResponseDto)
                .collect(Collectors.toList());
    }

    //Прием талона

    @Override
    public TicketResponseDto acceptanceTicket(Long id) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User currentUser = (User) auth.getPrincipal();
        Ticket ticket = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Билет не найден!!!"));

        TicketStatus newStatus = ticketStatusRepository.findById(2l)
                .orElseThrow(() -> new RuntimeException("Статус Активный с id 2 не найден!!!"));
        ticket.setTicketStatus(newStatus);
//        ticket.setOperatorId(currentUser);
        Ticket updatedTicket = repo.save(ticket);
        return mapToTicketResponseDto(updatedTicket);
    }

    //Завершение обработки

    @Override
    public TicketResponseDto completionTicket(Long id){

        Ticket ticket = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Билет не найден!!!"));

        TicketStatus newStatus = ticketStatusRepository.findById(3l)
                .orElseThrow(() -> new RuntimeException("Статус Завершенный с id 3 не найден!!!"));
        ticket.setTicketStatus(newStatus);

        ticket.setTimeOfFinished(LocalDateTime.now());
        ticket.setProcessingTime(Duration.between(ticket.getUpdateDate(), ticket.getTimeOfFinished()));

        Ticket updatedTicket = repo.save(ticket);
        return mapToTicketResponseDto(updatedTicket);
    }

    //Неявка
    private final ScheduledTaskService scheduledTaskService;

    @Autowired
    private TaskScheduler taskScheduler;

    @Override
    public TicketResponseDto absenceTicket(Long id){
        Ticket ticket = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Билет не найден!!!"));

        TicketStatus waitingStatus = ticketStatusRepository.findById(4l)
                .orElseThrow(() -> new RuntimeException("Статус Неактивный с id 4 не найден!!!"));
        ticket.setTicketStatus(waitingStatus);

        repo.save(ticket);

        scheduledTaskService.scheduleTask(() -> {
            checkAndUpdateStatus(id);
        }, 5, TimeUnit.MINUTES);

        return mapToTicketResponseDto(ticket);
    }
    private void checkAndUpdateStatus(Long ticketId) {
        Ticket ticket = repo.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Билет не найден!!!"));

        TicketStatus noShowStatus = ticketStatusRepository.findById(5L)
                .orElseThrow(() -> new RuntimeException("Статус Неявка с id 5 не найден!!!"));

        ticket.setTicketStatus(noShowStatus);
        repo.save(ticket);
    }

    // Принятие неявки

    @Override
    public TicketResponseDto getAbsenceTicket(Long id){

        Ticket ticket = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Билет не найден!!!"));

        TicketStatus newStatus = ticketStatusRepository.findById(2l)
                .orElseThrow(() -> new RuntimeException("Статус Активный с id 2 не найден!!!"));
        ticket.setTicketStatus(newStatus);
        repo.save(ticket);
        return mapToTicketResponseDto(ticket);
    }

    // Получения всех неявок за последние 5 минут

    @Override
    public List<TicketResponseDto> getAllTicketStatusAbsence(Long placeId) {
        LocalDateTime fiveMinutesAgo = LocalDateTime.now().minusMinutes(5);

        return ticketRepository.getAllTicketStatusAbsence(placeId, fiveMinutesAgo)
                .stream()
                .map(this::mapToTicketResponseDto)
                .collect(Collectors.toList());
    }

    //возвращает с пагинацией завершенные талоны

    @Override
    public Page<TicketResponseDto> getTicketStatusFinished(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {

        return ticketRepository.findAllFinishedTickets(startDate, endDate,  pageable)
                .map(this::mapToTicketResponseDto);
    }

    //возвращает с пагинацией по месту завершенные талоны

    @Override
    public Page<TicketResponseDto> getTicketStatusFinishedWithPlace(Long placeId, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {

        return ticketRepository.findAllFinishedTicketsWithPlace(placeId, startDate, endDate,  pageable)
                .map(this::mapToTicketResponseDto);
    }

  /*  @Override
    public List<OperatorTicketCountDto> getCountTicketByUser(LocalDateTime startDate, LocalDateTime endDate) {
        return ticketRepository.countProcessedTicketsByOperator(startDate, endDate);
    }
*/


}
