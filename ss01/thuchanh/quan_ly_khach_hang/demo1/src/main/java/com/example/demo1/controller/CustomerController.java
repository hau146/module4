package com.example.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomerController {
    @GetMapping("/customers")
    public String showList(HttpServletRequest request){
        return "customers/list.jsp";
    }
}
