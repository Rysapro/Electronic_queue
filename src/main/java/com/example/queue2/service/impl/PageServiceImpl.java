package com.example.queue2.service.impl;

import com.example.queue2.domain.dto.PageRequestDto;
import com.example.queue2.domain.dto.PageResponseDto;
import com.example.queue2.domain.model.Page;
import com.example.queue2.repository.PageRepository;
import com.example.queue2.service.PageService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PageServiceImpl extends BaseServiceImpl<Page, PageRequestDto, PageResponseDto, PageRepository>
        implements PageService {

    public PageServiceImpl(PageRepository pageRepository) {
        super(pageRepository);
    }

    @Override
    public Page toEntity(PageRequestDto dto) {
        return new Page(dto.name());
    }

    @Override
    public PageResponseDto toDTO(Page entity) {
        return new PageResponseDto(entity.getId(), entity.getName());
    }
}
