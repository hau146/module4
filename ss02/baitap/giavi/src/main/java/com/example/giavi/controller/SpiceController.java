package com.example.giavi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpiceController {
//    @GetMapping("/spice")
//    public String showFormList(){
//        return "list";
//    }
    @PostMapping("/spice/list")
    public String save(@RequestParam("condiment") String[] condiment, Model model){
        model.addAttribute("condiment",condiment);
        return "list";
    }
}
