package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.model.Page;
import com.example.queue2.service.PageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/page")
@Tag(name = "Страница(пагинация)")
public class PageController extends BaseController<Page, PageService> {

    public PageController(PageService pageService) {
        super(pageService);
    }
}
