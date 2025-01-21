package com.example.queue2.repository;

import com.example.queue2.model.dto.TicketStatusDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketStatusRepository extends JpaRepository<TicketStatusDto, Long> {
}
