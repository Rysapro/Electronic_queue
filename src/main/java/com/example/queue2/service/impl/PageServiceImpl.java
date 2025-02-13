package com.example.queue2.service.impl;

import com.example.queue2.domain.dto.PageRequestDto;
import com.example.queue2.domain.dto.PageResponseDto;
import com.example.queue2.domain.model.PageForRole;
import com.example.queue2.repository.PageRepository;
import com.example.queue2.service.PageService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PageServiceImpl extends BaseServiceImpl<PageForRole, PageRequestDto, PageResponseDto, PageRepository>
        implements PageService {

    public PageServiceImpl(PageRepository pageRepository) {
        super(pageRepository);
    }

    @Override
    public PageForRole toEntity(PageRequestDto dto) {
        return new PageForRole(dto.name());
    }

    @Override
    public PageResponseDto toDTO(PageForRole entity) {
        return new PageResponseDto(entity.getId(), entity.getName());
    }
}
