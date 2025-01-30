package com.example.queue2.service.impl;

import com.example.queue2.domain.dto.InformationRequestDTO;
import com.example.queue2.domain.dto.InformationResponseDTO;
import com.example.queue2.domain.model.Information;
import com.example.queue2.repository.InformationRepository;
import com.example.queue2.service.InformationService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class InformationServiceImpl extends BaseServiceImpl<Information, InformationRequestDTO, InformationResponseDTO, InformationRepository>
        implements InformationService {

    public InformationServiceImpl(InformationRepository repo) {
        super(repo);
    }

    @Override
    public Information toEntity(InformationRequestDTO dto) {
        return new Information(dto.declaration());
    }

    @Override
    public InformationResponseDTO toDTO(Information entity) {
        return new InformationResponseDTO(entity.getId(), entity.getDeclaration(), entity.getCreateDate());
    }
}
