package com.example.queue2.repository;

import com.example.queue2.domain.dto.TicketStatusDto;
import com.example.queue2.domain.model.TicketStatus;
import com.example.queue2.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketStatusRepository extends BaseRepository<TicketStatus> {
}
