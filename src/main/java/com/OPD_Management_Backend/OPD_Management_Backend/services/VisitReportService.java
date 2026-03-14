package com.OPD_Management_Backend.OPD_Management_Backend.services;

import java.util.List;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.VisitReport;

public interface VisitReportService {

	
		// to save/ insert data in VisitReports table
		VisitReport saveVisitReport (VisitReport visitreport);
		
		// get all VisitReport data from database
		List<VisitReport> getAllVisitReport();
		
		// get VisitReport by their id
		VisitReport getVisitReportById(int id);
		
		// delete VisitReport By their Id
		void deleteVisitReportById(int id);
}
