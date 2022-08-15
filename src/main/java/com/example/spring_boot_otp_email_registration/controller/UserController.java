package com.example.spring_boot_otp_email_registration.controller;

import com.example.spring_boot_otp_email_registration.model.User;
import com.example.spring_boot_otp_email_registration.service.OtpService;
import com.example.spring_boot_otp_email_registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private OtpService otpService;
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> displayUsers(){
        return userService.getUsers();
    }
    @GetMapping("user/save")
    public String saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    @GetMapping("user")
    public User displayUser(@RequestBody String email){
        return userService.getUser(email);
    }
}
