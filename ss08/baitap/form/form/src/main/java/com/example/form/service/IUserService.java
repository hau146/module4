package com.example.form.service;

import com.example.form.model.User;
import com.example.form.model.UserDto;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    boolean create(User user);
}
