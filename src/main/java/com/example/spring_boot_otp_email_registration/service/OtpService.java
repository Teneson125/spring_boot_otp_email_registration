package com.example.spring_boot_otp_email_registration.service;

import com.example.spring_boot_otp_email_registration.model.Otp;

public interface OtpService {
    void saveOtp(String email);
    Otp getOtp(String email);
    void removeOtp(Otp otp);
}
