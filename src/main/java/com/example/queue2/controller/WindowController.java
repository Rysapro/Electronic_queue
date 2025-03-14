package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.dto.PageRequestDto;
import com.example.queue2.domain.dto.PageResponseDto;
import com.example.queue2.domain.dto.WindowRequestDto;
import com.example.queue2.domain.dto.WindowResponseDto;
import com.example.queue2.domain.model.Window;
import com.example.queue2.service.PlaceService;
import com.example.queue2.service.UserService;
import com.example.queue2.service.WindowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/win")
public class WindowController extends BaseController<Window, WindowRequestDto, WindowResponseDto, WindowService> {

    private final UserService userService;
    private final PlaceService placeService;

    public WindowController(WindowService windowService, UserService userService, PlaceService placeService) {
        super(windowService);
        this.userService = userService;
        this.placeService = placeService;
    }

    @Override
    protected String getBasePath() {
        return "win";
    }

    @Override
    protected WindowRequestDto createEmptyDto() {
        return new WindowRequestDto(null, null, null, null);
    }

    @Override
    @GetMapping("/win-create")
    public String createForm(Model model) {
        model.addAttribute("form", createEmptyDto());
        model.addAttribute("places", placeService.findAll());
        model.addAttribute("users", userService.findAll());
        return "win-create";
    }

    @Override
    @PostMapping("/save")
    public String save(@ModelAttribute("form") WindowRequestDto model) {
        baseService.create(model);
        return "redirect:/win/win-list";
    }

    @GetMapping("/win-list")
    public String list(Model model) {
        List<WindowResponseDto> allItems = baseService.findAll();
        model.addAttribute("items", allItems);
        return "win-list";
    }

    @GetMapping("/win-edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        WindowResponseDto dto = baseService.findById(id);
        model.addAttribute("form", dto);
        model.addAttribute("places", placeService.findAll());
        model.addAttribute("users", userService.findAll());
        return "win-edit";
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("form") WindowRequestDto model) {
        baseService.update(id, model);
        return "redirect:/win/win-list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        baseService.deleteById(id);
        return "redirect:/win/win-list";
    }

}
