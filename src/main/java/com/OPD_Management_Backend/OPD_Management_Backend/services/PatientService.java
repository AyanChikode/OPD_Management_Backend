package com.OPD_Management_Backend.OPD_Management_Backend.services;

import java.util.List;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Patient;

public interface PatientService {
	
	
		// to save/ insert data in doctors table
		Patient savePatient (Patient patient);
		
		// get all doctor data from database
		List<Patient> getAllPatient();
		
		// get doctor by their id
		Patient getPatientById(int id);
		
		// delete doctor By their Id
		void deletePatientById(int id);
}
