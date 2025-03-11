package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.dto.InformationRequestDTO;
import com.example.queue2.domain.dto.InformationResponseDTO;
import com.example.queue2.domain.model.Information;
import com.example.queue2.service.InformationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/information")
@Tag(name = "Информация о декларации")
public class InformationController extends BaseController<Information, InformationRequestDTO, InformationResponseDTO, InformationService> {

    public InformationController(InformationService service) {
        super(service);
    }

/*    @Override
    public String list(Model model) {
        model.addAttribute("form", new InformationRequestDTO(""));
        return "information/create";
    }*/

    @Override
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("form", new InformationRequestDTO(""));
        return "information/create";
    }

    @Override
    @PostMapping("/save")
    public String save(@ModelAttribute("form") InformationRequestDTO model) {
        return super.save(model);
    }
}
