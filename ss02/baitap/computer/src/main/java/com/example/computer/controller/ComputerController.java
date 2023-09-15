package com.example.computer.controller;

import com.example.computer.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ComputerController {
    @Autowired
    private ComputerService computerService;
    @GetMapping("/caculator")
    public String showFormCaculator(){
        return "list";
    }
    @PostMapping("/caculator/calculate")
    public String resultCalculation(@RequestParam("sign") String sign,
                                    @RequestParam("number1") int number1,
                                    @RequestParam("number2") int number2,
                                    Model model){
        double result = computerService.Calculate(sign, number1, number2);
        model.addAttribute("result",result);
        return "list";
    }
}
