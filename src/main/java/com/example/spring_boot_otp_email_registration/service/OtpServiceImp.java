package com.example.spring_boot_otp_email_registration.service;

import com.example.spring_boot_otp_email_registration.model.Otp;
import com.example.spring_boot_otp_email_registration.repository.OtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class OtpServiceImp implements OtpService{
    @Autowired
    private OtpRepository otpRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void saveOtp(String email) {
        generateOtp(email);
    }

    @Override
    public Otp getOtp(String email) {
        return otpRepository.findByEmail(email);
    }

    @Override
    public void removeOtp(Otp otp) {
        otpRepository.delete(otp);
    }

    private void generateOtp(String email){
        Random random = new Random();
        int n = random.nextInt(999999);
        Otp otp = new Otp();
        otp.setEmail(email);
        otp.setOtp(String.format("%06d",n));
        otp.setCreatedDateTime(LocalDateTime.now());
        otpRepository.save(otp);
        sendMail(otp);
    }

    private void sendMail(Otp otp) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setSubject("One Time Password");
        mail.setText("Never share the OTP with anyone \n your OTP is "+otp.getOtp());
        mail.setTo(otp.getEmail());
        javaMailSender.send(mail);
    }

    public boolean checkOtp(String email, String otp){
        if(otpRepository.findByEmail(email)==null){
            return false;
        }
        Otp otpDetail = otpRepository.findByEmail(email);
        if(otp.equals(otpDetail.getOtp())){
            removeOtp(otpDetail);
            return true;
        }
        return false;
    }
}
