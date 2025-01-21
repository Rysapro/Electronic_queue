package com.example.queue2.service.base;

import com.example.queue2.domain.model.base.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseService<T extends BaseEntity> {
    T create(T dto);

    T findById(Long id);

    T update(T dto);

    void deleteById(Long id);

    List<T> findAll();

    Page<T> findAllWithPagination(Pageable pageable);
}

