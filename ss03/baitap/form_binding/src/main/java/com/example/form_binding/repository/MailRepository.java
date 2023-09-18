package com.example.form_binding.repository;

import com.example.form_binding.model.Mail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MailRepository implements IMailRepository{
    private static List<Mail> mailList = new ArrayList<>();
    static {
        mailList.add(new Mail(1,"English", 25, false, "King, Asgard" ));
        mailList.add(new Mail(2,"Vietnamese", 5,true, "Xin chao, Viet Nam" ));
    }
    @Override
    public List<Mail> showAll() {
        return mailList;
    }

    @Override
    public void edit(Mail mail) {
        mailList.set(mail.getId()-1, mail);
    }

    @Override
    public Mail findById(int id) {
        for (int i = 0; i < mailList.size() ; i++) {
            if(mailList.get(i).getId() == id){
                return mailList.get(i);
            }
        }
        return null;
    }
}
