package com.example.spring_boot_otp_email_registration.repository;

import com.example.spring_boot_otp_email_registration.model.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtpRepository extends JpaRepository<Otp, String > {
    Otp findByEmail(String email);
    void delete(Otp otp);
}
