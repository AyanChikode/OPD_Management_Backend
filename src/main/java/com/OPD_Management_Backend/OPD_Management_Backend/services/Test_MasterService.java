package com.OPD_Management_Backend.OPD_Management_Backend.services;

import java.util.List;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Test_Master;

public interface Test_MasterService {

		// to save/ insert data in Test_Masters table
		Test_Master saveTest_Master (Test_Master master);
		
		// get all Test_Masters data from database
		List<Test_Master> getAllTest_Master();
		
		// get Test_Masters by their id
		Test_Master getTest_MasterById(int id);
		
		// delete Test_Masters By their Id
		void deleteTest_MasterById(int id);
}
