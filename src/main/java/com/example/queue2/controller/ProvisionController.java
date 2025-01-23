package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.model.Provision;
import com.example.queue2.service.ProvisionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/provision")
@Tag(name = "Услуги")
public class ProvisionController extends BaseController<Provision, ProvisionService> {
    private final ProvisionService provisionService;

    public ProvisionController(ProvisionService provisionService) {
        super(provisionService);
        this.provisionService = provisionService;
    }
}
