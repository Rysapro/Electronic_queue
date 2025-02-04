package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.dto.PriorityRequestDto;
import com.example.queue2.domain.dto.PriorityResponseDto;
import com.example.queue2.domain.model.Priority;
import com.example.queue2.service.PriorityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/priority")
@Tag(name = "Приоритет")
public class PriorityController extends BaseController<Priority, PriorityRequestDto, PriorityResponseDto, PriorityService> {

    public PriorityController(PriorityService priorityService) {
        super(priorityService);
    }
}
