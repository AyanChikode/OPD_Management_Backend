package com.OPD_Management_Backend.OPD_Management_Backend.services;

import java.util.List;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Doctor;

public interface DoctorService {
	
	// to save/ insert data in doctors table
	Doctor saveDoctor (Doctor doctor);
	
	// get all doctor data from database
	List<Doctor> getAllDoctor();
	
	// get doctor by their id
	Doctor getDoctorById(int id);
	
	// delete doctor By their Id
	void deleteDoctorById(int id);
	

}
