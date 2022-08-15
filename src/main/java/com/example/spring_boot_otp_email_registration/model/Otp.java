package com.example.spring_boot_otp_email_registration.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Otp {
    @Id
    private String email;
    private String otp;
    private LocalDateTime createdDateTime;

    public Otp() {
    }

    public Otp(String email, String otp, LocalDateTime createdDateTime) {
        this.email = email;
        this.otp = otp;
        this.createdDateTime = createdDateTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
}
