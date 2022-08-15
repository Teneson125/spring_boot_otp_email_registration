package com.example.spring_boot_otp_email_registration.repository;

import com.example.spring_boot_otp_email_registration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String > {
    User findByEmail(String email);
}
