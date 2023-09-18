package com.example.form_binding.controller;

import com.example.form_binding.model.Mail;
import com.example.form_binding.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private IMailService mailService;

    @ModelAttribute("listLanguages")
    public String[] getListLanguages() {
        return new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
    }

    @ModelAttribute("listPageSize")
    public int[] getListPageSize() {
        return new int[]{5, 10, 15, 25, 50, 100};
    }

    @GetMapping("/home")
    public String showHome(Model model) {
        List<Mail> mailList = mailService.showAll();
        model.addAttribute("mailList", mailList);
        return "home";
    }

    @GetMapping("/settings/{id}")
    public String showForm(@PathVariable int id, Model model) {
        Mail mail = mailService.findById(id);
        model.addAttribute("mail", mail);
        return "settings";
    }

    @PostMapping("/settings")
    public String editMail(@ModelAttribute Mail mail,
                           RedirectAttributes redirectAttributes) {
        mailService.edit(mail);
        redirectAttributes.addFlashAttribute("mess", "successful mail correction");
        return "redirect:/mail/home";
    }
}
