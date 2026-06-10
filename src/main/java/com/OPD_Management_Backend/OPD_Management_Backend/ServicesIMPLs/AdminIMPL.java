package com.OPD_Management_Backend.OPD_Management_Backend.ServicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Admin;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Doctor;
import com.OPD_Management_Backend.OPD_Management_Backend.exception.DatabaseException;
import com.OPD_Management_Backend.OPD_Management_Backend.exception.ResourceNotFoundException;
import com.OPD_Management_Backend.OPD_Management_Backend.repositories.AdminRepository;
import com.OPD_Management_Backend.OPD_Management_Backend.services.AdminService;

@Service
public class AdminIMPL implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdminById(int id) {
        return adminRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Admin Not Found"));
    }

    @Override
    public void deleteAdmin(int id) {
        adminRepository.deleteById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return adminRepository.existsByEmail(email);
    }
    
    @Override
    public String verifyOtp(String email, String otp) {

        Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Admin not found with email: " + email));

        if (admin.getEmailOtp() != null &&
                admin.getEmailOtp().equals(otp)) {

            admin.setEmailVerify(true);
            admin.setEmailOtp(null);

            adminRepository.save(admin);

            return "OTP Verified Successfully";
        }

        return "Invalid OTP";
    }
}

