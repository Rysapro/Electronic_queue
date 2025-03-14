package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.dto.RoleRequestDto;
import com.example.queue2.domain.dto.RoleResponseDto;
import com.example.queue2.domain.model.Role;
import com.example.queue2.service.PageService;
import com.example.queue2.service.RoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController<Role, RoleRequestDto, RoleResponseDto, RoleService> {

    private final PageService pageService;

    public RoleController(RoleService service, PageService pageService) {
        super(service);
        this.pageService = pageService;
    }

    @Override
    protected String getBasePath() {
        return "role";
    }

    @Override
    protected RoleRequestDto createEmptyDto() {
        return new RoleRequestDto(null, null);
    }

    @GetMapping("/role-create")
    public String createForm(Model model) {
        model.addAttribute("form", createEmptyDto());
        model.addAttribute("pages", pageService.findAll());
        return "role-create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("form") RoleRequestDto model) {
        baseService.create(model);
        return "redirect:/role/role-list";
    }

    @GetMapping("/role-list")
    public String list(Model model) {
        model.addAttribute("items", baseService.findAll());
        return "role-list";
    }

    @GetMapping("/role-edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("form", baseService.findById(id));
        model.addAttribute("pages", pageService.findAll());
        return "role-edit";
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("form") RoleRequestDto model) {
        baseService.update(id, model);
        return "redirect:/role/role-list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        baseService.deleteById(id);
        return "redirect:/role/role-list";
    }
}