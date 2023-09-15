package com.example.baitap2.controller;

import com.example.baitap2.service.DictionaryService;
import com.example.baitap2.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Dictionary {
    @Autowired
    private IDictionaryService dictionaryService;
    @GetMapping("/dictionary")
    public String showForm(){
        return "form_dictionary";
    }
    @PostMapping("/dictionary/result")
    public String resultDictionary(@RequestParam String dictionary, Model model){
        String result = dictionaryService.vocabularyConversion(dictionary);
        if (result == null){
            model.addAttribute("result","không có từ này");
        } else {
            model.addAttribute("result",result);
        }
        return "form_dictionary";
    }
}
