package com.example.queue2.service.impl;
//
//import com.example.queue2.domain.model.Ticket;
//import com.example.queue2.repository.TicketRepository;
//import com.example.queue2.service.TicketService;
//import com.example.queue2.service.base.BaseServiceImpl;
//import org.springframework.stereotype.Service;
//
//import java.sql.Timestamp;
//
//@Service
//public class TicketServiceImpl extends BaseServiceImpl<Ticket,  TicketRepository> implements TicketService {
//
//    public TicketServiceImpl(TicketRepository repo) {
//        super(repo);
//    }

//    @Override
//    public Ticket toEntity(TicketRequestDto dto) {
//        return new Ticket( Timestamp.valueOf(dto.createDate()),  dto.number(),dto.timeOfCreateTicket(),
//                Timestamp.valueOf(dto.updateDate()), dto.priority(), dto.updatedBy(), dto.operatorId(),
//                dto.place(), dto.provision(), dto.information());
//    }
//
//    @Override
//    public TicketResponseDto toDTO(Ticket entity) {
//        return new TicketResponseDto(entity.getId(), entity.getCreateDate(), entity.getUpdateDate(),
//                entity.getTimeOfCreateTicket(), entity.getNumber(), entity.getTimeOfFinished(),
//                entity.getProcessingTime(), entity.getPriority(), entity.getUpdatedBy(),
//                entity.getOperatorId(), entity.getPlace(), entity.getProvision(), entity.getInformation());
//    }
//}
