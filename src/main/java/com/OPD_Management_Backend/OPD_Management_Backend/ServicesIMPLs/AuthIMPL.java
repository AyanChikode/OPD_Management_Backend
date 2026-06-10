package com.OPD_Management_Backend.OPD_Management_Backend.ServicesIMPLs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.OPD_Management_Backend.OPD_Management_Backend.dtos.LoginRequestDto;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.*;
import com.OPD_Management_Backend.OPD_Management_Backend.exception.ResourceNotFoundException;
import com.OPD_Management_Backend.OPD_Management_Backend.repositories.*;
import com.OPD_Management_Backend.OPD_Management_Backend.response.*;
import com.OPD_Management_Backend.OPD_Management_Backend.security.JwtUtil;
import com.OPD_Management_Backend.OPD_Management_Backend.services.AuthService;

@Service
public class AuthIMPL implements AuthService {

    @Autowired private DoctorRepository doctorRepository;
    @Autowired private AdminRepository adminRepository;
    @Autowired private ReceptionRepository receptionRepository;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private JwtUtil jwtUtil;

    @Override
    public JwtResponse doctorLogin(LoginRequestDto dto) {

        Doctor doctor = doctorRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Email Not Found"));

        if (!passwordEncoder.matches(dto.getPassword(), doctor.getPassword()))
            throw new RuntimeException("Invalid Password");

        String role = doctor.getRole().name();
        String token = jwtUtil.generateToken(doctor.getEmail(), role);

        doctor.setToken(token);

        doctorRepository.save(doctor);

        return new JwtResponse(token, role, doctor);
    }

    @Override
    public JwtResponse adminLogin(LoginRequestDto dto) {

        Admin admin = adminRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Email Not Found"));

        if (!passwordEncoder.matches(dto.getPassword(), admin.getPassword()))
            throw new RuntimeException("Invalid Password");

        String role = admin.getRole().name();
        String token = jwtUtil.generateToken(admin.getEmail(), role);

     // SAVE TOKEN
     admin.setToken(token);

     adminRepository.save(admin);

     return new JwtResponse(token, role, admin);
    }

    @Override
    public JwtResponse receptionLogin(LoginRequestDto dto) {

        Reception reception = receptionRepository.findByEmail(dto.getEmail());

        if (reception == null)
            throw new ResourceNotFoundException("Email Not Found");

        if (!passwordEncoder.matches(dto.getPassword(), reception.getPassword()))
            throw new RuntimeException("Invalid Password");

        String role = reception.getRole().name();
        String token = jwtUtil.generateToken(reception.getEmail(), role);

        reception.setToken(token);

        receptionRepository.save(reception);

        return new JwtResponse(token, role, reception);
    }
}