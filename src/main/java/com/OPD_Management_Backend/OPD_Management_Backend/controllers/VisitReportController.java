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

import com.OPD_Management_Backend.OPD_Management_Backend.dtos.VisitReportDto;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Visit;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.VisitReport;
import com.OPD_Management_Backend.OPD_Management_Backend.services.VisitReportService;
import com.OPD_Management_Backend.OPD_Management_Backend.services.VisitService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/visitreports")
public class VisitReportController {
	
	@Autowired
	private VisitReportService visitReportService;
	
	@Autowired
	private VisitService visitService;
	
	
	@PostMapping("/register")
	public ResponseEntity<VisitReport> saveVisit_ReportEntity(@Valid @RequestBody VisitReportDto Dto){
		
		VisitReport visitReport = new VisitReport();
		
		
		visitReport.setFile_type(Dto.getFile_type());
		visitReport.setFile_name(Dto.getFile_name());
		visitReport.setFile_url(Dto.getFile_url());
		visitReport.setCreated_at(LocalDateTime.now());


		Visit visit = visitService.getVisitById(Dto.getVisitid());
		

		
		visitReport.setVisitid(visit);
		
		VisitReport saved = visitReportService.saveVisitReport(visitReport);
		
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<VisitReport>> getAllDataFromVisit_Report(){
		
		List<VisitReport> visitReport = visitReportService.getAllVisitReport();
		if(visitReport == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(visitReport, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VisitReport> getVisit_ReportId(@PathVariable("id") int id){
		
		VisitReport visitReport = visitReportService.getVisitReportById(id);
		if(visitReport == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
					
		}
		return new ResponseEntity<>(visitReport, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVisitReport(@PathVariable("id") int id){
		
		VisitReport visit_Report = visitReportService.getVisitReportById(id);
		if(visit_Report == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		visitReportService.deleteVisitReportById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<VisitReport>updateVisitReportById(@PathVariable("id") int id,@Valid @RequestBody VisitReportDto Dto){
		VisitReport visitReport = visitReportService.getVisitReportById(id);
		if(visitReport == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		visitReport.setFile_type(Dto.getFile_type());
		visitReport.setFile_name(Dto.getFile_name());
		visitReport.setFile_url(Dto.getFile_url());
		visitReport.setCreated_at(LocalDateTime.now());


		Visit visit = visitService.getVisitById(Dto.getVisitid());
		

		
		visitReport.setVisitid(visit);
		
		VisitReport saved = visitReportService.saveVisitReport(visitReport);
		
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}
}




