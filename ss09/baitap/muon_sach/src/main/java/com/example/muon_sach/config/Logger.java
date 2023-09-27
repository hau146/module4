package com.example.muon_sach.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Random;

@Aspect
@Component
public class Logger {
    @After("execution(* com.example.muon_sach.controller.BookController.rent(..))")
    public void rentBook(){
        System.out.println("Vừa có người thuê sách");
    }

}
