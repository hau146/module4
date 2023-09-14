package com.example.baitap1.controller;

import com.example.baitap1.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;
    @GetMapping("/currency")
    public String showForm(){
        return "form";
    }
    @PostMapping("/currency/result")
    public String resultCurrency(@RequestParam int usd, Model model){
        double result = currencyService.currencyCalculation(usd);
        model.addAttribute("result",result);
        return "form";
    }
}
