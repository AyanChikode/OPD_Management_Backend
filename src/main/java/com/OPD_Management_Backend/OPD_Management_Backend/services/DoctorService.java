package com.OPD_Management_Backend.OPD_Management_Backend.services;

import java.util.List;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Doctor;

public interface DoctorService {
	
	Doctor saveDoctor (Doctor doctor);
	
	List<Doctor> getAllDoctor();
	
	Doctor getDoctorById(int id);
	
	void deleteDoctorById(int id);
	
	Doctor getDoctorByEmail(String email);

	String verifyOtp(String email, String otp);


}
