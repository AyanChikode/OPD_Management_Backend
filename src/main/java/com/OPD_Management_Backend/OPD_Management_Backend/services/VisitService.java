package com.OPD_Management_Backend.OPD_Management_Backend.services;

import java.util.List;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Visit;

public interface VisitService {
	
			// to save/ insert data in Visits table
			Visit saveVisit(Visit visit);
			
			// get all Visit data from database
			List<Visit> getAllVisit();
			
			// get Visit by their id
			Visit getVisitById(int id);
			
			// delete Visit By their Id
			void deleteVisitById(int id);

}
