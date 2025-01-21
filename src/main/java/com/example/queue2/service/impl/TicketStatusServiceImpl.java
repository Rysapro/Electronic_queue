//package com.example.queue2.service.impl;
//
//import com.example.queue2.domain.dto.TicketStatusDto;
//import com.example.queue2.repository.TicketStatusRepository;
//import com.example.queue2.service.TicketStatusService;
//
//import java.util.List;
//import java.util.Optional;
//
//public class TicketStatusServiceImpl implements TicketStatusService {
//
//    private final TicketStatusRepository ticketStatusRepository;
//
//    public TicketStatusServiceImpl(TicketStatusRepository ticketStatusRepository) {
//        this.ticketStatusRepository = ticketStatusRepository;
//    }
//
//    @Override
//    public TicketStatusDto save(TicketStatusDto ticketStatusDto) {
//        return ticketStatusRepository.save(ticketStatusDto);
//    }
//
//    @Override
//    public Optional<TicketStatusDto> getById(Long id) {
//        return ticketStatusRepository.findById(id);
//    }
//
//    @Override
//    public List<TicketStatusDto> getAll() {
//        return ticketStatusRepository.findAll();
//    }
//}
