package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.dto.InformationResponseDTO;
import com.example.queue2.domain.dto.UserRequestDto;
import com.example.queue2.domain.dto.UserResponseDto;
import com.example.queue2.domain.model.User;
import com.example.queue2.service.PlaceService;
import com.example.queue2.service.RoleService;
import com.example.queue2.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController<User, UserRequestDto, UserResponseDto, UserService> {

    private final UserService userService;
    private final RoleService roleService;
    private final PlaceService placeService;

    public UserController(UserService userService, UserService userService1, RoleService roleService, PlaceService placeService) {
        super(userService);
        this.userService = userService1;
        this.roleService = roleService;
        this.placeService = placeService;
    }

    @Override
    protected String getBasePath() {
        return "user";
    }

    @Override
    protected UserRequestDto createEmptyDto() {
        return new UserRequestDto(null, null, null, null, null, null, null);
    }

    @GetMapping("/user-list")
    public String showList(Model model) {
        List<UserResponseDto> allItems = baseService.findAll();
        model.addAttribute("items", allItems);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createForm(Model model) {
        model.addAttribute("form", createEmptyDto());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("places", placeService.findAll());
        return "user-create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("form") UserRequestDto model) {
               baseService.create(model);
        return "redirect:/user/user-list";
    }

    @GetMapping("/user-edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        UserResponseDto dto = baseService.findById(id);
        model.addAttribute("form", dto);
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("places", placeService.findAll());
        return "user-edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("form") UserRequestDto model) {
        baseService.update(id, model);
        return "redirect:/user/user-list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        baseService.deleteById(id);
        return "redirect:/user/user-list";
    }
}