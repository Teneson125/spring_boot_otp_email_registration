package com.example.spring_boot_otp_email_registration.service;

import com.example.spring_boot_otp_email_registration.model.User;
import com.example.spring_boot_otp_email_registration.model.UserLogin;
import com.example.spring_boot_otp_email_registration.model.UserRegister;
import com.example.spring_boot_otp_email_registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OtpServiceImp otpServiceImp;

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

    public String registerUser(UserRegister userRegister){
        if(otpServiceImp.checkOtp(userRegister.getEmail(),userRegister.getOtp())){
            if(userRepository.findByEmail(userRegister.getEmail()) != null){
                return "email already taken";
            }
            User user = new User();
            user.setEmail(userRegister.getEmail());
            user.setUsername(userRegister.getUsername());
            user.setName(userRegister.getName());
            user.setCreatedDateTime(LocalDateTime.now());
            userRepository.save(user);
            return "success";
        }
        return "invalid otp";
    }
    public HashMap<String, User> userLogin(UserLogin userLogin){
        HashMap<String, User> hashMap = new HashMap<>();
        if(otpServiceImp.checkOtp(userLogin.getEmail(),userLogin.getOtp())){
            if(userRepository.findByEmail(userLogin.getEmail()) == null){
                hashMap.put("user not register", null);
                return hashMap;
            }
            hashMap.put("success", userRepository.findByEmail(userLogin.getEmail()));
            return hashMap;
        }
        hashMap.put("otp invalid or expired", null);
        return hashMap;
    }
}
