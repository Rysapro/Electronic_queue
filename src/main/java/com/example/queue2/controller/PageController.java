package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.dto.PageRequestDto;
import com.example.queue2.domain.dto.PageResponseDto;
import com.example.queue2.domain.model.PageForRole;
import com.example.queue2.service.PageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/page")
@Tag(name = "Страница")
public class PageController extends BaseController<PageForRole, PageRequestDto, PageResponseDto, PageService> {

    public PageController(PageService pageService) {
        super(pageService);
    }
}
