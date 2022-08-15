package com.example.spring_boot_otp_email_registration.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class User {
    @Id
    private String email;
    private String username;
    private String name;
    private LocalDateTime createdDateTime;

    public User() {
    }

    public User(String email, String username, String name, LocalDateTime createdDateTime) {
        this.email = email;
        this.username = username;
        this.name = name;
        this.createdDateTime = createdDateTime;
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

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
}
