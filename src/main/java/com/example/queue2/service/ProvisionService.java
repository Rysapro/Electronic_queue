package com.example.queue2.service;

import com.example.queue2.domain.dto.ProvisionRequestDto;
import com.example.queue2.domain.dto.ProvisionResponseDto;
import com.example.queue2.domain.model.Provision;
import com.example.queue2.service.base.BaseService;

public interface ProvisionService extends BaseService<Provision, ProvisionRequestDto, ProvisionResponseDto> {
}
