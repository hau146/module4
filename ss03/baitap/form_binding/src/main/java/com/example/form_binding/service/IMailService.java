package com.example.form_binding.service;

import com.example.form_binding.model.Mail;

import java.util.List;

public interface IMailService {
    List<Mail> showAll();
    void edit(Mail mail);
    Mail findById(int id);
}
