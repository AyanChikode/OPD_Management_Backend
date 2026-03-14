package com.OPD_Management_Backend.OPD_Management_Backend.services;

import java.util.List;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Diagnostic;

public interface DiagnosticService {

	Diagnostic saveDiagnostic (Diagnostic diagnostic);
	
	// get all doctor data from database
	List<Diagnostic> getAllDiagnostic();
	
	// get doctor by their id
	Diagnostic getDiagnosticById(int id);
	
	// delete doctor By their Id
	void deleteDiagnosticById(int id);
}
