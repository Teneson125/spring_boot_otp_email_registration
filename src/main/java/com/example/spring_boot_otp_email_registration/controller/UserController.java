package com.example.spring_boot_otp_email_registration.controller;

import com.example.spring_boot_otp_email_registration.model.User;
import com.example.spring_boot_otp_email_registration.model.UserLogin;
import com.example.spring_boot_otp_email_registration.model.UserRegister;
import com.example.spring_boot_otp_email_registration.service.OtpServiceImp;
import com.example.spring_boot_otp_email_registration.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private OtpServiceImp otpService;
    @Autowired
    private UserServiceImp userService;

    @PostMapping("otp/send")
    public void sendOtp(@RequestBody String email){
        otpService.saveOtp(email);
    }
    @GetMapping("user/register")
    public String userRegister(@RequestBody UserRegister userRegister){
        return userService.registerUser(userRegister);
    }
    @GetMapping("user/login")
    public HashMap<String, User> userLogin(@RequestBody UserLogin userLogin){
        return userService.userLogin(userLogin);
    }

    //for admin use
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
