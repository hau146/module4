package com.example.form.service;



import com.example.form.model.User;
import com.example.form.model.UserDto;
import com.example.form.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean create(User user) {
        try {
            userRepository.save(user);
        } catch (Exception e){
            return false;
        }
        return true;
    }
}
