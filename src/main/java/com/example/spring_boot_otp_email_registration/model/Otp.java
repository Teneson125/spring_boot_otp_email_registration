package com.example.spring_boot_otp_email_registration.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import java.sql.Time;
import java.util.Date;

@Entity
public class Otp {

    private String email;
    private String otp;
    @JsonFormat(pattern = "DD-MM-YYYY")
    private Date date;
    @JsonFormat(pattern = "HH:MM:SS")
    private Time time;

    public Otp() {
    }

    public Otp(String email, String otp, Date date, Time time) {
        this.email = email;
        this.otp = otp;
        this.date = date;
        this.time = time;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
