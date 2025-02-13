package com.example.queue2.service;

import com.example.queue2.domain.dto.PageRequestDto;
import com.example.queue2.domain.dto.PageResponseDto;
import com.example.queue2.domain.model.PageForRole;
import com.example.queue2.service.base.BaseService;

public interface PageService extends BaseService<PageForRole, PageRequestDto, PageResponseDto> {
}
