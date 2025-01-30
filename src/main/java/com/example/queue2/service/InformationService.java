package com.example.queue2.service;

import com.example.queue2.domain.dto.InformationRequestDTO;
import com.example.queue2.domain.dto.InformationResponseDTO;
import com.example.queue2.domain.model.Information;
import com.example.queue2.service.base.BaseService;

public interface InformationService extends BaseService<Information, InformationRequestDTO, InformationResponseDTO> {
}
