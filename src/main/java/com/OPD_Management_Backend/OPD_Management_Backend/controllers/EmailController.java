package com.OPD_Management_Backend.OPD_Management_Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OPD_Management_Backend.OPD_Management_Backend.dtos.EmailRequestDto;
import com.OPD_Management_Backend.OPD_Management_Backend.dtos.VerifyEmailOtpDto;
import com.OPD_Management_Backend.OPD_Management_Backend.response.EmailResponse;
import com.OPD_Management_Backend.OPD_Management_Backend.services.EmailService;
import com.OPD_Management_Backend.OPD_Management_Backend.services.VerifyOtpService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/email")
@CrossOrigin(origins = "http://localhost:5173")

public class EmailController {
	
	@Autowired
    private EmailService emailService;

    @Autowired
    private VerifyOtpService otpService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(
            @RequestBody EmailRequestDto emailRequestDto) {

        String response = emailService.sendEmail(emailRequestDto);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/verify-email-otp")
    public EmailResponse verifyEmailOtp(@Valid @RequestBody VerifyEmailOtpDto verifyEmailOtpDto) {

        return otpService.verifyEmailOtp(verifyEmailOtpDto);
    }
}
