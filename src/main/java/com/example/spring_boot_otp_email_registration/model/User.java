package com.example.spring_boot_otp_email_registration.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;

@Entity
public class User {
    @Id
    private String email;
    private String username;
    private String name;
    @JsonFormat(pattern = "DD-MM-YYYY")
    private Date createdDate;
    @JsonFormat(pattern = "HH:MM:SS")
    private Time createdTime;

    public User() {
    }

    public User(String email, String username, String name, Date createdDate, Time createdTime) {
        this.email = email;
        this.username = username;
        this.name = name;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Time getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Time createdTime) {
        this.createdTime = createdTime;
    }
}
