package com.OPD_Management_Backend.OPD_Management_Backend.services;

import java.util.List;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Admin;

public interface AdminService {

    Admin saveAdmin(Admin admin);

    List<Admin> getAllAdmin();

    Admin getAdminById(int id);

    void deleteAdmin(int id);

    boolean existsByEmail(String email);
    
	String verifyOtp(String email, String otp);

}