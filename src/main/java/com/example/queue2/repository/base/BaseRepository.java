package com.example.queue2.repository.base;

import com.example.queue2.domain.model.base.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository <E extends BaseEntity> extends JpaRepository<E, Long > {
    Page<E> findAll(Pageable pageable);
}
