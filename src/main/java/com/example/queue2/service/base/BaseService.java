package com.example.queue2.service.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseService<ENTITY, REQUEST_DTO, RESPONSE_DTO> {

    RESPONSE_DTO create(REQUEST_DTO dto);

    RESPONSE_DTO findById(Long id);

    RESPONSE_DTO update(Long id, REQUEST_DTO dto);

    void deleteById(Long id);

    List<RESPONSE_DTO> findAll();

    Page<RESPONSE_DTO> findAllWithPagination(Pageable pageable);

    ENTITY toEntity(REQUEST_DTO dto);

    RESPONSE_DTO toDTO(ENTITY entity);
}


