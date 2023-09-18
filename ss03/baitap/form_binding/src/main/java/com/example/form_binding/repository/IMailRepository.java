package com.example.form_binding.repository;

import com.example.form_binding.model.Mail;

import java.util.List;

public interface IMailRepository {

    List<Mail> showAll();
    void edit(Mail mail);
    Mail findById(int id);
}
