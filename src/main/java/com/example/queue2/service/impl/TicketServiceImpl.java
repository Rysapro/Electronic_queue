package com.example.queue2.service.impl;

import com.example.queue2.domain.model.Ticket;
import com.example.queue2.domain.model.User;
import com.example.queue2.exceprtion.ResourceNotFoundException;
import com.example.queue2.repository.TicketRepository;
import com.example.queue2.repository.UserRepository;
import com.example.queue2.service.TicketService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl extends BaseServiceImpl<Ticket, TicketRepository> implements TicketService {
    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        super(ticketRepository);
        this.ticketRepository = ticketRepository;
    }
//    private final UserRepository userRepository;
//
//    public TicketServiceImpl(TicketRepository ticketRepository, UserRepository userRepository) {
//        super(ticketRepository);
//        this.ticketRepository = ticketRepository;
//        this.userRepository = userRepository;
//    }


//    @Override
//    public Ticket updateTicket(Long ticketId, Ticket ticketDetails, Long userId) {
//        Ticket existingTicket = ticketRepository.findById(ticketId)
//                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id " + ticketId));
//
//       if (ticketDetails.getTimeOfFinished() != null) {
//            existingTicket.setTimeOfFinished(ticketDetails.getTimeOfFinished());
//        }
//        if (ticketDetails.getProcessingTime() != null) {
//            existingTicket.setProcessingTime(ticketDetails.getProcessingTime());
//        }
//        User updatingUser = userRepository.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
//        existingTicket.getUpdatedBy().add(updatingUser);
//        return ticketRepository.save(existingTicket);
//    }
}
