package com.OPD_Management_Backend.OPD_Management_Backend.services;

import java.util.List;


import com.OPD_Management_Backend.OPD_Management_Backend.entities.PathologyTest;

public interface PathologyTestService {
	
	

	PathologyTest savePathologyTest (PathologyTest pathologyTest);
	
	// get all doctor data from database
	List<PathologyTest> getAllPathologyTest();
	
	// get doctor by their id
	PathologyTest getPathologyTestById(int id);
	
	// delete doctor By their Id
	void deletePathologyTestById(int id);
}
