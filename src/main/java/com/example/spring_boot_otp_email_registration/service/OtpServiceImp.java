package com.example.spring_boot_otp_email_registration.service;

import com.example.spring_boot_otp_email_registration.model.Otp;
import com.example.spring_boot_otp_email_registration.model.UserRegister;
import com.example.spring_boot_otp_email_registration.repository.OtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class OtpServiceImp implements OtpService{
    @Autowired
    private OtpRepository otpRepository;

    @Override
    public void saveOtp(String email) {
        generateOtp(email);
    }

    @Override
    public Otp getOtp(String email) {
        return otpRepository.findByEmail(email);
    }

    @Override
    public void removeOtp(String email) {
        otpRepository.deleteByEmail(email);
    }

    private void generateOtp(String email){
        Random random = new Random();
        int n = random.nextInt(999999);
        Otp otp = new Otp();
        otp.setEmail(email);
        otp.setOtp(String.format("%06d",n));
        otp.setCreatedDateTime(LocalDateTime.now());
        otpRepository.save(otp);
    }
    public boolean checkOtp(String email, String otp){
        Otp otpDetail = otpRepository.findByEmail(email);
        return otp.equals(otpDetail.getOtp());
    }
}
