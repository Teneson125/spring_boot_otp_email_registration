package com.example.spring_boot_otp_email_registration.service;

import com.example.spring_boot_otp_email_registration.model.Otp;

public interface OtpService {
    void saveOtp(Otp otp);
    Otp getOtp(String email);
    void removeOtp(String email);
}
