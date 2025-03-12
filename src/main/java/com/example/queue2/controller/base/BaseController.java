package com.example.queue2.controller.base;

import com.example.queue2.service.base.BaseService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public abstract class BaseController<ENTITY, REQUEST_DTO, RESPONSE_DTO, SERVICE extends BaseService<ENTITY, REQUEST_DTO, RESPONSE_DTO>> {

    protected final SERVICE baseService;
    protected abstract String getBasePath();
    protected abstract REQUEST_DTO createEmptyDto();

    public BaseController(SERVICE service) {
        this.baseService = service;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<RESPONSE_DTO> allItems = baseService.findAll();
        model.addAttribute("items", allItems);
        return "list"; // list.html (в templates)
    }

    @GetMapping("create")
    public String createForm(Model model) {
        model.addAttribute("form", createEmptyDto()); // Создаем пустой DTO через абстрактный метод
        return "create"; // info-create.html
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("form") REQUEST_DTO model) {
        baseService.create(model);
        return "redirect:" + getBasePath() + "/list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        RESPONSE_DTO dto = baseService.findById(id);
        model.addAttribute("form", dto);
        return "edit"; // edit.html
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("form") REQUEST_DTO model) {
        baseService.update(id, model);
        return "redirect:" + getBasePath() + "/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        baseService.deleteById(id);
        return "redirect:" + getBasePath() + "/list";
    }
}