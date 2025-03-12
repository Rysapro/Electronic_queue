package com.example.queue2.controller;

import com.example.queue2.controller.base.BaseController;
import com.example.queue2.domain.dto.UserRequestDto;
import com.example.queue2.domain.dto.UserResponseDto;
import com.example.queue2.domain.model.User;
import com.example.queue2.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@Tag(name = "Пользователь")
public class UserController extends BaseController<User, UserRequestDto, UserResponseDto, UserService> {

    @Override
    protected String getBasePath() {
        return "";
    }

    @Override
    protected UserRequestDto createEmptyDto() {
        return null;
    }

    public UserController(UserService userService) {
        super(userService);
    }

    @Override
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("form", new UserRequestDto("", "", "", false, null, null)); // Заполняем дефолтными значениями
        return "user/create";
    }

    @Override
    @PostMapping("/save")
    public String save(@ModelAttribute("form") UserRequestDto model) {
        return super.save(model);
    }



 /*   @Override
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        UserResponseDto dto = baseService.findById(id);
        model.addAttribute("form", new UserRequestDto(
                dto.getName(),
                dto.getSurname(),
                dto.getPatronymic(),
                dto.getBlocked(),
                dto.getPlaceId(),
                dto.getRoleId()
        ));
        return "user/edit";
    }*/
}
