package com.OPD_Management_Backend.OPD_Management_Backend.controllers;

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

import com.OPD_Management_Backend.OPD_Management_Backend.dtos.MedicineDto;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Doctor;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Medicine;
import com.OPD_Management_Backend.OPD_Management_Backend.services.DoctorService;
import com.OPD_Management_Backend.OPD_Management_Backend.services.MedicineService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicines")
@CrossOrigin
public class MedicineController {
	
	@Autowired
	private MedicineService medicineService;
	
	@Autowired
	private DoctorService doctorservice;
	
	@PostMapping("/register")
	public ResponseEntity<Medicine> saveMedicine(@Valid @RequestBody MedicineDto dto) {
		Medicine medicine = new Medicine();

		medicine.setMedicine_name(dto.getMedicine_name());
		medicine.setType(dto.getType());

		Doctor doctor = doctorservice.getDoctorById(dto.getDoctor_id());

		medicine.setDoctorid(doctor);

		Medicine savedmedicine = medicineService.saveMedicine(medicine);
		return new ResponseEntity<>(savedmedicine, HttpStatus.CREATED);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Medicine>> getPatientById() {
		List<Medicine> medicine = medicineService.getAllMedicine();
		if (medicine == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(medicine, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Medicine> getPatientById(@PathVariable("id") int id) {

		Medicine medicine = medicineService.getMedicineById(id);

		if (medicine == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(medicine, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Medicine> updatedPatientById(@PathVariable("id") int id,@Valid @RequestBody MedicineDto dto) {
		Medicine medicine = medicineService.getMedicineById(id);
		
		if (medicine == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		medicine.setMedicine_name(dto.getMedicine_name());
		medicine.setType(dto.getType());

		Doctor doctor = doctorservice.getDoctorById(dto.getDoctor_id());

		medicine.setDoctorid(doctor);

		Medicine savedmedicine = medicineService.saveMedicine(medicine);
		return new ResponseEntity<>(savedmedicine, HttpStatus.CREATED);
	}

	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Medicine> deleteMedicineById(@PathVariable("id") int id){
		
		Medicine medicine = medicineService.getMedicineById(id);

		if (medicine == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		medicineService.deleteMedicineById(id);
		return new ResponseEntity<>(medicine, HttpStatus.OK);
	}
	
}
