package com.example.spring_boot_otp_email_registration.service;

import com.example.spring_boot_otp_email_registration.model.Otp;
import com.example.spring_boot_otp_email_registration.repository.OtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtpServiceImp implements OtpService{
    @Autowired
    private OtpRepository otpRepository;

    @Override
    public void saveOtp(Otp otp) {
        otpRepository.save(otp);
    }

    @Override
    public Otp getOtp(String email) {
        return otpRepository.findByEmail(email);
    }

    @Override
    public void removeOtp(String email) {
        otpRepository.deleteByEmail(email);
    }
}
