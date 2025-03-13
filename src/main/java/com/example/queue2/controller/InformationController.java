package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.dto.InformationRequestDTO;
import com.example.queue2.domain.dto.InformationResponseDTO;
import com.example.queue2.domain.model.Information;
import com.example.queue2.service.InformationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@RequestMapping("/information")
@Tag(name = "Информация о декларации")
public class InformationController extends BaseController<Information, InformationRequestDTO, InformationResponseDTO, InformationService> {

    public InformationController(InformationService service) {
        super(service);
    }

    @Override
    protected String getBasePath() {
        return "information";
    }

    @Override
    protected InformationRequestDTO createEmptyDto() {
        return new InformationRequestDTO(null);
    }

    @GetMapping("/info-create")
    public String createForm(Model model) {
        model.addAttribute("form", createEmptyDto()); // Создаем пустой DTO через абстрактный метод
        return "info-create"; // info-create.html
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("form") InformationRequestDTO model) {
        baseService.create(model);
        return "redirect:/information/info-list";
    }

    @GetMapping("/info-list")
    public String list(Model model) {
        List<InformationResponseDTO> allItems = baseService.findAll();
        model.addAttribute("items", allItems);
        return "info-list"; // list.html (в templates)
    }

    @GetMapping("/info-edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        InformationResponseDTO dto = baseService.findById(id);
        model.addAttribute("form", dto);
        return "info-edit"; // edit.html
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("form") InformationRequestDTO model) {
        baseService.update(id, model);
        return "redirect:/information/info-list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        baseService.deleteById(id);
        return "redirect:/information/info-list";
    }
}