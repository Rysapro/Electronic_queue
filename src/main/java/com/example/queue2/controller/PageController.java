package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.dto.PageRequestDto;
import com.example.queue2.domain.dto.PageResponseDto;
import com.example.queue2.domain.dto.PlaceRequestDto;
import com.example.queue2.domain.dto.PlaceResponseDto;
import com.example.queue2.domain.model.PageForRole;
import com.example.queue2.service.PageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/page")
@Tag(name = "Страница")
public class PageController extends BaseController<PageForRole, PageRequestDto, PageResponseDto, PageService> {

    @Override
    protected String getBasePath() {
        return "page";
    }

    @Override
    protected PageRequestDto createEmptyDto() {
        return new PageRequestDto(null);
    }

    @Override
    @GetMapping("/page-create")
    public String createForm(Model model) {
        model.addAttribute("form", createEmptyDto());
        return "page-create";
    }

    @Override
    @PostMapping("/save")
    public String save(@ModelAttribute("form") PageRequestDto model) {
        baseService.create(model);
        return "redirect:/page/page-list";
    }

    public PageController(PageService pageService) {
        super(pageService);
    }

    @GetMapping("/page-list")
    public String list(Model model) {
        List<PageResponseDto> allItems = baseService.findAll();
        model.addAttribute("items", allItems);
        return "page-list";
    }

    @GetMapping("/page-edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        PageResponseDto dto = baseService.findById(id);
        model.addAttribute("form", dto);
        return "page-edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("form") PageRequestDto model) {
        baseService.update(id, model);
        return "redirect:/page/page-list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        baseService.deleteById(id);
        return "redirect:/page/page-list";
    }
}
