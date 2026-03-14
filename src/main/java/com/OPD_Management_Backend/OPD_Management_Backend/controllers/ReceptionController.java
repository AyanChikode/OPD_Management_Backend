package com.OPD_Management_Backend.OPD_Management_Backend.controllers;

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

import com.OPD_Management_Backend.OPD_Management_Backend.dtos.ReceptionDto;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Doctor;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Reception;
import com.OPD_Management_Backend.OPD_Management_Backend.services.DoctorService;
import com.OPD_Management_Backend.OPD_Management_Backend.services.ReceptionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/receptions")
public class ReceptionController {
	

	@Autowired
	private ReceptionService receptionService;
	
	@Autowired
	private DoctorService doctorService;
	


	
	@PostMapping("/regsiter")
	public ResponseEntity<Reception> saveDataFromReception( @Valid @RequestBody ReceptionDto receptionDto){
		
		Reception reception = new Reception();
		
		reception.setName(receptionDto.getName());
		reception.setEmail(receptionDto.getEmail());
		reception.setMobile_no(receptionDto.getMobile_no());
		reception.setShift(receptionDto.getShift());
		reception.setPassword((receptionDto.getPassword()));

		
		Doctor doctor = doctorService.getDoctorById(receptionDto.getDoctorid());
		
		reception.setDoctorid(doctor);
		
		Reception saveReception = receptionService.saveReception(reception);
		
		return new ResponseEntity<>(saveReception, HttpStatus.CREATED);
	}
	

	@GetMapping("/list")
	public ResponseEntity<List<Reception>> getAllDataFromReceptionTable(){
		
		List<Reception> reception = receptionService.getAllReception();
		if(reception == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new  ResponseEntity<>(reception , HttpStatus.OK);		
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Reception> getReceptionById(@PathVariable("id") int id){
		
		Reception reception = receptionService.getReceptionById(id);
		
		if(reception == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(reception , HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Reception> updateReceptionById(@PathVariable("id") int id, @Valid @RequestBody ReceptionDto receptionDto){
		
		Reception reception = receptionService.getReceptionById(id);
		if(reception == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		reception.setName(receptionDto.getName());
		reception.setEmail(receptionDto.getEmail());
		reception.setMobile_no(receptionDto.getMobile_no());
		reception.setShift(receptionDto.getShift());
		
		Doctor doctor = doctorService.getDoctorById(receptionDto.getDoctorid());
		
		reception.setDoctorid(doctor);
		
		Reception updateReception = receptionService.saveReception(reception);
		
		return new ResponseEntity<>(updateReception , HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteReceptionUsingId(@PathVariable("id") int id){
		
		Reception reception = receptionService.getReceptionById(id);
		
		if(reception == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		receptionService.deleteReceptionById(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

	
	
}
