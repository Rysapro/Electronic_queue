package com.example.queue2.repository;

import com.example.queue2.domain.dto.PriorityDto;
import com.example.queue2.domain.model.Priority;
import com.example.queue2.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriorityRepository extends BaseRepository<Priority> {

}
