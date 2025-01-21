package com.example.queue2.repository;

import com.example.queue2.model.Information;
import com.example.queue2.model.dto.InformationDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<InformationDto, Long> {
}
