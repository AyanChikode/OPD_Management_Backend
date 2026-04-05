package com.OPD_Management_Backend.OPD_Management_Backend.ServicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Admin;
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
		
		try {
			return adminRepository.save(admin);
			
		} catch (Exception e) {
			
			throw new DatabaseException("Failed to save admin due to database error");
			
		}
	}

	@Override
	public List<Admin> getAllAdmin() {
		
		try {
			
			return adminRepository.findAll();
			
		} catch (Exception e) {
			
			throw new DatabaseException
			("Failed to find admin due to database error");
		}
	}

	

	@Override
	public void deleteAdmin(int id) {
		
		try {
			
			adminRepository.deleteById(id);
			
		} catch (Exception e) {
			
			throw new DatabaseException("Failed to delete admin due to database error.");
		}
	}

//	@Override
//	public Admin getAdminByEmail(String email) {
//		// TODO Auto-generated method stub
//		try {
//			
//			return adminRepository.findByEmail(email).orElseThrow(() -> 
//			new ResourseNotFoundException("Admin not found with email: " + email));
//		} catch (Exception e) {
//
//			throw new DataBaseException("Failed to get admin due to database error");              
//		}
//	}

	@Override
	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		return adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin Not Found With id: " + id) );
	}



}
