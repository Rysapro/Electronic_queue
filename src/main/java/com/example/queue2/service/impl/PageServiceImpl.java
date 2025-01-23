package com.example.queue2.service.impl;

import com.example.queue2.domain.model.Page;
import com.example.queue2.repository.PageRepository;
import com.example.queue2.service.PageService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PageServiceImpl extends BaseServiceImpl<Page, PageRepository> implements PageService {

    private final PageRepository pageRepository;

    public PageServiceImpl(PageRepository pageRepository) {
        super(pageRepository);
        this.pageRepository = pageRepository;
    }

}
