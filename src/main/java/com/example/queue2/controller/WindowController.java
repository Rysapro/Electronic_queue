package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.dto.WindowRequestDto;
import com.example.queue2.domain.dto.WindowResponseDto;
import com.example.queue2.domain.model.Window;
import com.example.queue2.service.WindowService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/window")
@Tag(name = "окно")
public class WindowController extends BaseController<Window, WindowRequestDto, WindowResponseDto, WindowService> {

    public WindowController(WindowService windowService) {
        super(windowService);
    }
}
