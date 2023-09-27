package com.example.muon_sach.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Random;

@Aspect
@Component
public class Logger {
    private static int count = 0;
    @After("execution(* com.example.muon_sach.controller.BookController.showList(..))")
    public void showList(){
        count++;
        System.out.println("Vừa có người truy cập");
    }
    @After("execution(* com.example.muon_sach.controller.BookController.rent(..))")
    public void rentBook(){
        System.out.println("Vừa có người thuê sách");
    }
    @After("execution(* com.example.muon_sach.controller.BookController.giveBook(..))")
    public void giveBook(){
        System.out.println("Vừa có người trả sách");
    }

}
