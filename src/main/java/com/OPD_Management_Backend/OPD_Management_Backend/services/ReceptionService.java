package com.OPD_Management_Backend.OPD_Management_Backend.services;

import java.util.List;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Doctor;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Reception;


public interface ReceptionService {
	
		Reception saveReception (Reception reception);
		
		// get all doctor data from database
		List<Reception> getAllReception();
		
		// get doctor by their id
		Reception getReceptionById(int id);
		
		// delete doctor By their Id
		void deleteReceptionById(int id);

		
		Reception getReceptionByEmail(String email);

		String verifyOtp(String email, String otp);
}
