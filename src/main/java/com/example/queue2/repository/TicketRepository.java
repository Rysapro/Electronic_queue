package com.example.queue2.repository;

import com.example.queue2.domain.model.Ticket;
import com.example.queue2.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface TicketRepository extends BaseRepository<Ticket> {
    @Query("SELECT MAX(t.ticketCode) FROM Ticket t WHERE t.place.placeName = :placeName AND t.provision.provisionName = :provisionName" )
    String findMaxTicketCodeFor(@Param("placeName") String placeName, @Param("provisionName") String provisionName);
}
