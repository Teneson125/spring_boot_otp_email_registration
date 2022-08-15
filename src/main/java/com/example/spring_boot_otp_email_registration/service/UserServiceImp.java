package com.example.spring_boot_otp_email_registration.service;

import com.example.spring_boot_otp_email_registration.model.User;
import com.example.spring_boot_otp_email_registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public String saveUser(User user) {
        if(userRepository.findByEmail(user.getEmail()) != null){
            return "email already taken";
        }
        userRepository.save(user);
        return "Success";
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }
}
