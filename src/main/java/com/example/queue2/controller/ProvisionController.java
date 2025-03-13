package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.dto.ProvisionRequestDto;
import com.example.queue2.domain.dto.ProvisionResponseDto;
import com.example.queue2.domain.model.Provision;
import com.example.queue2.service.PlaceService;
import com.example.queue2.service.ProvisionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/provision")
@Tag(name = "Услуги")
public class ProvisionController extends BaseController<Provision, ProvisionRequestDto, ProvisionResponseDto, ProvisionService> {

    private final PlaceService placeService;

    public ProvisionController(ProvisionService service, PlaceService placeService) {
        super(service);
        this.placeService = placeService;
    }

    @Override
    protected String getBasePath() {
        return "provision";
    }

    @Override
    protected ProvisionRequestDto createEmptyDto() {
        return new ProvisionRequestDto(null, null, null);
    }

    @GetMapping("/provision-create")
    public String createForm(Model model) {
        model.addAttribute("form", createEmptyDto());
        model.addAttribute("places", placeService.findAll());
        return "provision-create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("form") ProvisionRequestDto model) {
        baseService.create(model);
        return "redirect:/provision/provision-list";
    }

    @GetMapping("/provision-list")
    public String list(Model model) {
        List<ProvisionResponseDto> allItems = baseService.findAll();
        model.addAttribute("items", allItems);
        return "provision-list";
    }

    @GetMapping("/provision-edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        ProvisionResponseDto dto = baseService.findById(id);
        model.addAttribute("form", dto);
        model.addAttribute("places", placeService.findAll());
        return "provision-edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("form") ProvisionRequestDto model) {
        baseService.update(id, model);
        return "redirect:/provision/provision-list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        baseService.deleteById(id);
        return "redirect:/provision/provision-list";
    }
}
