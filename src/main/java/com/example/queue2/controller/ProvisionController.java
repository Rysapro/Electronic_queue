package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.dto.ProvisionRequestDto;
import com.example.queue2.domain.dto.ProvisionResponseDto;
import com.example.queue2.domain.model.Provision;
import com.example.queue2.service.ProvisionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/provision")
@Tag(name = "Услуги")
public class ProvisionController extends BaseController<Provision, ProvisionRequestDto, ProvisionResponseDto, ProvisionService> {

    @Override
    protected String getBasePath() {
        return "";
    }

    @Override
    protected ProvisionRequestDto createEmptyDto() {
        return null;
    }

    public ProvisionController(ProvisionService provisionService) {
        super(provisionService);
    }
}
