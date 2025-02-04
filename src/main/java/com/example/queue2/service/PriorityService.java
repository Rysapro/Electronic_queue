package com.example.queue2.service;

import com.example.queue2.domain.dto.PriorityRequestDto;
import com.example.queue2.domain.dto.PriorityResponseDto;
import com.example.queue2.domain.model.Priority;
import com.example.queue2.service.base.BaseService;

public interface PriorityService extends BaseService<Priority, PriorityRequestDto, PriorityResponseDto> {
}
