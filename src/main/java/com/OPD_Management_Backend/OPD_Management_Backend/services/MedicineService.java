package com.OPD_Management_Backend.OPD_Management_Backend.services;

import java.util.List;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Doctor;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Medicine;

public interface MedicineService {
	
	// to save/ insert data in Medicines table
	Medicine saveMedicine (Medicine medicine);
	
	// get all Medicine data from database
	List<Medicine> getAllMedicine();
	
	// get Medicine by their id
	Medicine getMedicineById(int id);
	
	// delete Medicine By their Id
	void deleteMedicineById(int id);
}
