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

import com.OPD_Management_Backend.OPD_Management_Backend.dtos.ReferralCenterDto;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Doctor;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.ReferralCenter;
import com.OPD_Management_Backend.OPD_Management_Backend.services.DoctorService;
import com.OPD_Management_Backend.OPD_Management_Backend.services.ReferralCenterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/referralcenters")
@CrossOrigin(origins = "http://localhost:5173")
public class ReferralCenterController {

	@Autowired
	private ReferralCenterService referralCenterService;
	
	@Autowired
	private DoctorService doctorService;  // to get id
	
	// insert data from referral_center 
	@PostMapping("/register")
	public ResponseEntity<ReferralCenter> saveReferralCenter(@Valid @RequestBody ReferralCenterDto referralCenterDto){
		
		ReferralCenter referralCenter = new ReferralCenter();
		
		referralCenter.setName(referralCenterDto.getName());
		referralCenter.setType(referralCenterDto.getType());
		referralCenter.setContact_info(referralCenterDto.getContact_info());
		referralCenter.setAddress(referralCenterDto.getAddress());
		referralCenter.setCreated_at(LocalDateTime.now());
		

		Doctor doctor = doctorService.getDoctorById(referralCenterDto.getDoctorid());
		
		referralCenter.setDoctorid(doctor);
		
		ReferralCenter saveReferral_Center = referralCenterService.saveReferralCenter(referralCenter);
		
		return new ResponseEntity<>(saveReferral_Center, HttpStatus.CREATED);
	}

	// get all data from referral_center
	@GetMapping("/list")
	public ResponseEntity<List<ReferralCenter>> getAllDataFromReferral_Center(){
		
		List<ReferralCenter> referral_Center = referralCenterService.getAllReferralCenter();
		
		if(referral_Center == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(referral_Center, HttpStatus.OK);
	}
	
	// get specific id from referral_center
	@GetMapping("/{id}")
	public ResponseEntity<ReferralCenter> getSpecificReferral_CenterById(@PathVariable("id") int id){
		
		ReferralCenter referral_Center = referralCenterService.getReferralCenterById(id);
		if(referral_Center == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(referral_Center , HttpStatus.OK);
	} 
	
	// update specific id from referral_center
	@PutMapping("/update/{id}")
	public ResponseEntity<ReferralCenter> updateReferral_CenterId(@PathVariable("id") int id,@Valid  @RequestBody ReferralCenterDto referralCenterDto){
		
		ReferralCenter referralCenter= referralCenterService.getReferralCenterById(id);
		if(referralCenter == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		referralCenter.setName(referralCenterDto.getName());
		referralCenter.setType(referralCenterDto.getType());
		referralCenter.setContact_info(referralCenterDto.getContact_info());
		referralCenter.setAddress(referralCenterDto.getAddress());
		referralCenter.setCreated_at(LocalDateTime.now());
		
		// to get doctor id show data from id
		Doctor doctor = doctorService.getDoctorById(referralCenterDto.getDoctorid());
		
		referralCenter.setDoctorid(doctor);
		
		ReferralCenter updateReferral_Center = referralCenterService.saveReferralCenter(referralCenter);
		
		return new ResponseEntity<>(updateReferral_Center, HttpStatus.OK);
	}
	
	// delete specific id from referral_Center
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteSpecificIdFromReferral_Center(@PathVariable("id") int id){
		
		ReferralCenter referral_Center= referralCenterService.getReferralCenterById(id);
		if(referral_Center == null) {
			 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		referralCenterService.deleteReferralCenterById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
