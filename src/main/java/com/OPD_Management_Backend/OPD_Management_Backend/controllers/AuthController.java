package com.OPD_Management_Backend.OPD_Management_Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.OPD_Management_Backend.OPD_Management_Backend.dtos.LoginRequestDto;
import com.OPD_Management_Backend.OPD_Management_Backend.response.JwtResponse;
import com.OPD_Management_Backend.OPD_Management_Backend.services.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/doctor/login")
    public JwtResponse doctorLogin(@RequestBody LoginRequestDto dto) {
        return authService.doctorLogin(dto);
    }

    @PostMapping("/admin/login")
    public JwtResponse adminLogin(@RequestBody LoginRequestDto dto) {
        return authService.adminLogin(dto);
    }

    @PostMapping("/reception/login")
    public JwtResponse receptionLogin(@RequestBody LoginRequestDto dto) {
        return authService.receptionLogin(dto);
    }
}