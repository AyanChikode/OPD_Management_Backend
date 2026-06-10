package com.OPD_Management_Backend.OPD_Management_Backend.ServicesIMPLs;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.OPD_Management_Backend.OPD_Management_Backend.dtos.EmailRequestDto;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Doctor;
import com.OPD_Management_Backend.OPD_Management_Backend.exception.ResourceNotFoundException;
import com.OPD_Management_Backend.OPD_Management_Backend.repositories.DoctorRepository;
import com.OPD_Management_Backend.OPD_Management_Backend.services.EmailService;
import com.OPD_Management_Backend.OPD_Management_Backend.services.GenerateOtp;

@Service
public class EmailServiceIMPL implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private GenerateOtp generateOtp;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public String sendEmail(EmailRequestDto emailRequest) {

        Doctor doctor = doctorRepository
                .findByEmail(emailRequest.getTo())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Doctor Email Not Found"));

        // Dynamic OTP Generate
        int otp = generateOtp.generateRandomOtp();

        // Save OTP in DB
        doctor.setEmailOtp(otp);

        // Expiry Time (5 minutes)
        doctor.setOtpExpiry(LocalDateTime.now().plusMinutes(5));

        doctorRepository.save(doctor);

        try {

            SimpleMailMessage message = new SimpleMailMessage();

            message.setTo(emailRequest.getTo());
            message.setSubject("Email Verification OTP");

            message.setText(
                    "Your OTP is : " + otp +
                    "\n\nOTP valid for 5 minutes."
            );

            mailSender.send(message);

            return "OTP Sent Successfully";

        } catch (Exception e) {

            return "Error while sending email : " + e.getMessage();
        }
    }
}