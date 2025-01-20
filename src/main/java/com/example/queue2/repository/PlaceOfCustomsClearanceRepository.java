package com.example.queue2.repository;

import com.example.queue2.model.PlaceOfCustomsClearance;
import com.example.queue2.model.dto.PlaceOfCustomsClearanceDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceOfCustomsClearanceRepository extends JpaRepository<PlaceOfCustomsClearanceDto, Long> {
}
