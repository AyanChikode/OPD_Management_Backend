package com.OPD_Management_Backend.OPD_Management_Backend.ServicesIMPLs;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OPD_Management_Backend.OPD_Management_Backend.dtos.VerifyEmailOtpDto;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Doctor;
import com.OPD_Management_Backend.OPD_Management_Backend.exception.ResourceNotFoundException;
import com.OPD_Management_Backend.OPD_Management_Backend.repositories.DoctorRepository;
import com.OPD_Management_Backend.OPD_Management_Backend.response.EmailResponse;
import com.OPD_Management_Backend.OPD_Management_Backend.services.VerifyOtpService;

@Service
public class VerifyEmailOtpIMPL implements VerifyOtpService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public EmailResponse verifyEmailOtp(VerifyEmailOtpDto verifyEmailOtpDto) {

        Doctor doctor = doctorRepository
                .findByEmail(verifyEmailOtpDto.getEmail())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Email Not Exist"));

        if (doctor.getOtpExpiry().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("OTP Expired");
        }

        if (!doctor.getEmailOtp().equals(verifyEmailOtpDto.getOtp())) {
            throw new RuntimeException("Invalid OTP");
        }

        doctor.setEmailVerify(true);

        // Clear OTP after verification
        doctor.setEmailOtp(null);
        doctor.setOtpExpiry(null);

        doctorRepository.save(doctor);

        return new EmailResponse(true,
                "Email Verified Successfully");
    }
}