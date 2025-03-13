package com.example.queue2.repository;

import com.example.queue2.domain.dto.PlaceTicketCountDto;
import com.example.queue2.domain.model.Place;
import com.example.queue2.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaceRepository extends BaseRepository<Place> {
    @Query("SELECT new com.example.queue2.domain.dto.PlaceTicketCountDto(p.name, COUNT(t)) " +
            "FROM Ticket t " +
            "JOIN t.place p " +
            "WHERE t.ticketStatus.id = 1 " +
            "GROUP BY p.name")
    List<PlaceTicketCountDto> countActiveTicketsPerPlace();
}
