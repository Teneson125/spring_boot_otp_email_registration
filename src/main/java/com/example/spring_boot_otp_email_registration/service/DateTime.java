package com.example.spring_boot_otp_email_registration.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
    String getDate(LocalDateTime dateTime){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM uuu");
        return dateTimeFormatter.format(dateTime);
    }
    String getTime(LocalDateTime dateTime){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm s");
        return dateTimeFormatter.format(dateTime);
    }
}
