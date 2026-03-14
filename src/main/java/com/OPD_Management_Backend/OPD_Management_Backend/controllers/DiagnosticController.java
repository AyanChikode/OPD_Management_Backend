package com.OPD_Management_Backend.OPD_Management_Backend.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OPD_Management_Backend.OPD_Management_Backend.dtos.DiagnosticDto;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Diagnostic;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Doctor;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Visit;
import com.OPD_Management_Backend.OPD_Management_Backend.services.DiagnosticService;
import com.OPD_Management_Backend.OPD_Management_Backend.services.DoctorService;
import com.OPD_Management_Backend.OPD_Management_Backend.services.VisitService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/diagnostics")
public class DiagnosticController {
	
	@Autowired
	private DiagnosticService diagnosticservice;
	
	@Autowired
	private VisitService visitservice;
	
	@Autowired
	private DoctorService doctorservice;
	
	@PostMapping("/register")
	public ResponseEntity<Diagnostic> saveDiagnostic(@Valid @RequestBody DiagnosticDto diagnosticDto){
		
		Diagnostic diagnostic = new Diagnostic();
		diagnostic.setName(diagnosticDto.getName());
		diagnostic.setCreated_at(LocalDateTime.now());

		Visit visit =visitservice.getVisitById(diagnosticDto.getVisitid());
		
		// to get doctor id or show info
		Doctor doctor = doctorservice.getDoctorById(diagnosticDto.getDoctorid());
		
		diagnostic.setDoctorid(doctor);
		diagnostic.setVisitid(visit);
		
		Diagnostic saveDiagnostic = diagnosticservice.saveDiagnostic(diagnostic);
		
		return new ResponseEntity<>(saveDiagnostic, HttpStatus.CREATED);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Diagnostic>> getAllDiagnostic(){
		
		List<Diagnostic> diagnostic = diagnosticservice.getAllDiagnostic();
		
		if(diagnostic == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(diagnostic, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Diagnostic> getDiagnosticById(@PathVariable("id") int id){
		
		Diagnostic diagnostic = diagnosticservice.getDiagnosticById(id);
		if(diagnostic == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(diagnostic, HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Diagnostic> updateDiagnostic(@PathVariable("id") int id,@Valid  @RequestBody DiagnosticDto diagnosticDto){
		
		Diagnostic diagnostic = diagnosticservice.getDiagnosticById(id);
		if(diagnostic == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		diagnostic.setName(diagnosticDto.getName());
		diagnostic.setCreated_at(LocalDateTime.now());
		
		// to get visit id or show info
		Visit visit = visitservice.getVisitById(diagnosticDto.getVisitid());
				
		// to get doctor id or show info
		Doctor doctor = doctorservice.getDoctorById(diagnosticDto.getDoctorid());
		
		diagnostic.setDoctorid(doctor);
		
		diagnostic.setVisitid(visit);
		
		Diagnostic updateDiagnostic = diagnosticservice.saveDiagnostic(diagnostic);
		
		return new ResponseEntity<>(updateDiagnostic, HttpStatus.OK);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDiagnosticById(@PathVariable("id") int id){
		
		Diagnostic diagnostic = diagnosticservice.getDiagnosticById(id);
		if(diagnostic == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		diagnosticservice.deleteDiagnosticById(id);
		
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}
