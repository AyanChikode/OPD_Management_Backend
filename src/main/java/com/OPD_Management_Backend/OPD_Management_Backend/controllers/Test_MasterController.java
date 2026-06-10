package com.OPD_Management_Backend.OPD_Management_Backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OPD_Management_Backend.OPD_Management_Backend.dtos.Test_MasterDto;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Doctor;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Test_Master;
import com.OPD_Management_Backend.OPD_Management_Backend.services.DoctorService;

import com.OPD_Management_Backend.OPD_Management_Backend.services.Test_MasterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/testmasters")
@CrossOrigin(origins = "http://localhost:5173")
public class Test_MasterController {
	
	@Autowired
	private Test_MasterService masterService;

	@Autowired
	private DoctorService doctorservice;
	
	@PostMapping("/register")
	public ResponseEntity<Test_Master> saveTestMaster(@Valid @RequestBody Test_MasterDto dto) {
		Test_Master master = new Test_Master();

		master.setTest_name(dto.getTest_name());
		master.setNormal_range(dto.getNormal_range());
		master.setUnit(dto.getUnit());

	Doctor doctor = doctorservice.getDoctorById(dto.getDoctorid());

	master.setDoctorid(doctor);

	Test_Master savedtestmaster = masterService.saveTest_Master(master);
	return new ResponseEntity<>(savedtestmaster, HttpStatus.CREATED);

	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Test_Master>> getPatientById() {
		List<Test_Master> masters = masterService.getAllTest_Master();
		if (masters == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(masters, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Test_Master> getPatientById(@PathVariable("id") int id) {

		Test_Master masters = masterService.getTest_MasterById(id);

		if (masters == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(masters, HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Test_Master> updatedTest_MasterById(@PathVariable("id") int id,@Valid @RequestBody Test_MasterDto dto){
		
		Test_Master masters = masterService.getTest_MasterById(id);

		if (masters == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		masters.setTest_name(dto.getTest_name());
		masters.setNormal_range(dto.getNormal_range());
		masters.setUnit(dto.getUnit());

	Doctor doctor = doctorservice.getDoctorById(dto.getDoctorid());

	masters.setDoctorid(doctor);

	Test_Master savedtestmaster = masterService.saveTest_Master(masters);
	return new ResponseEntity<>(savedtestmaster, HttpStatus.CREATED);

	}
}
