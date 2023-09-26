package com.example.form.service;

import com.example.form.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    boolean create(User user);
}
