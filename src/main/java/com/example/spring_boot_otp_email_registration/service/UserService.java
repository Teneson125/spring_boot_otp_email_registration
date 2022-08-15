package com.example.spring_boot_otp_email_registration.service;

import com.example.spring_boot_otp_email_registration.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    String saveUser(User user);
    User getUser(String email);
}
