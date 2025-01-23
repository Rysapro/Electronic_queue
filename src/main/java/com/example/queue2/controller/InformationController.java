package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.model.Information;
import com.example.queue2.service.InformationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/information")
@Tag(name = "Информация о деклорации")
public class InformationController extends BaseController<Information, InformationService> {

    private final InformationService informationService;

    public InformationController(InformationService informationService) {
        super(informationService);
        this.informationService = informationService;
    }
}
