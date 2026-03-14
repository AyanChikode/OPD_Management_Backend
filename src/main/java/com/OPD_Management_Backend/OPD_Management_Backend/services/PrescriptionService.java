package com.OPD_Management_Backend.OPD_Management_Backend.services;

import java.util.List;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Prescription;

public interface PrescriptionService {

	
	// to save/ insert data in doctors table
	Prescription savePrescription (Prescription prescription);
		
		// get all doctor data from database
		List<Prescription> getAllPrescription();
		
		// get doctor by their id
		Prescription getPrescriptionById(int id);
		
		// delete doctor By their Id
		void deletePrescriptionById(int id);
}
