package com.OPD_Management_Backend.OPD_Management_Backend.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OPD_Management_Backend.OPD_Management_Backend.dtos.PatientDto;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Doctor;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Patient;
import com.OPD_Management_Backend.OPD_Management_Backend.services.DoctorService;
import com.OPD_Management_Backend.OPD_Management_Backend.services.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "http://localhost:5173")
public class PatientController {

	@Autowired
	private PatientService patientservice;

	@Autowired
	private DoctorService doctorservice;

	@PostMapping("/register")
	public ResponseEntity<Patient> savePatient(@Valid @RequestBody PatientDto dto) {
		Patient patient = new Patient();

		patient.setPatient_name(dto.getPatient_name());
		patient.setAge(dto.getAge());
		patient.setGender(dto.getGender());
		patient.setMobileNo(dto.getMobileNo());
		patient.setAddress(dto.getAddress());
		patient.setBlood_group(dto.getBlood_group());
		patient.setHeight(dto.getHeight());
		patient.setSmoking(dto.getSmoking());
		patient.setAlcohol(dto.getAlcohol());
		patient.setTobacco(dto.getTobacco());
		patient.setPatient_name(dto.getPatient_name());
		patient.setCreated_at(LocalDateTime.now());

		Doctor doctor = doctorservice.getDoctorById(dto.getDoctor_id());

		patient.setDoctorid(doctor);

		Patient savedpatient = patientservice.savePatient(patient);
		return new ResponseEntity<>(savedpatient, HttpStatus.CREATED);
	}

	@GetMapping("/list")
	public ResponseEntity<List<Patient>> getPatientById() {
		List<Patient> patient = patientservice.getAllPatient();
		if (patient == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(patient, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable("id") int id) {

		Patient patient = patientservice.getPatientById(id);

		if (patient == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(patient, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Patient> updatedPatientById(@PathVariable("id") int id,@Valid @RequestBody PatientDto dto) {
		Patient patient = patientservice.getPatientById(id);

		if (patient == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		patient.setPatient_name(dto.getPatient_name());
		patient.setAge(dto.getAge());
		patient.setGender(dto.getGender());
		patient.setMobileNo(dto.getMobileNo());
		patient.setAddress(dto.getAddress());
		patient.setBlood_group(dto.getBlood_group());
		patient.setHeight(dto.getHeight());
		patient.setSmoking(dto.getSmoking());
		patient.setAlcohol(dto.getAlcohol());
		patient.setTobacco(dto.getTobacco());
		patient.setPatient_name(dto.getPatient_name());
		patient.setUpdated_at(LocalDateTime.now());
		Doctor doctor = doctorservice.getDoctorById(dto.getDoctor_id());

		patient.setDoctorid(doctor);

		Patient savedpatient = patientservice.savePatient(patient);
		return new ResponseEntity<>(savedpatient, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	
	public ResponseEntity<Patient> deletePatientById(@PathVariable("id") int id) {

		Patient patient = patientservice.getPatientById(id);

		if (patient == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		patientservice.deletePatientById(id);
		return new ResponseEntity<>(patient, HttpStatus.OK);
	}
}
