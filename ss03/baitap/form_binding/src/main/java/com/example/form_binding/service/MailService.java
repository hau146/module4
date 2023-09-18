package com.example.form_binding.service;

import com.example.form_binding.model.Mail;
import com.example.form_binding.repository.IMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService implements IMailService {
    @Autowired
    private IMailRepository mailRepository;
    @Override
    public List<Mail> showAll() {
        return mailRepository.showAll();
    }

    @Override
    public void edit(Mail mail) {
        mailRepository.edit(mail);
    }

    @Override
    public Mail findById(int id) {
        return mailRepository.findById(id);
    }
}
