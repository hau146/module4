package com.example.form.controller;

import com.example.form.model.User;
import com.example.form.model.UserDto;
import com.example.form.repository.IUserRepository;
import com.example.form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String showList(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute UserDto userDto,
                         RedirectAttributes redirectAttributes,
                         BindingResult bindingResult) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        } else {

            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userService.create(user);
            redirectAttributes.addFlashAttribute("mess", "thêm thành công");
            return "redirect:";
        }
    }

}