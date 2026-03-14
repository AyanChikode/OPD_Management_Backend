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

import com.OPD_Management_Backend.OPD_Management_Backend.dtos.ReferralDto;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Doctor;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Patient;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Referral;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.ReferralCenter;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Visit;
import com.OPD_Management_Backend.OPD_Management_Backend.services.DoctorService;
import com.OPD_Management_Backend.OPD_Management_Backend.services.PatientService;
import com.OPD_Management_Backend.OPD_Management_Backend.services.ReferralCenterService;
import com.OPD_Management_Backend.OPD_Management_Backend.services.ReferralService;
import com.OPD_Management_Backend.OPD_Management_Backend.services.VisitService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/referrals")
@CrossOrigin
public class ReferralController {
	
	@Autowired
	private ReferralService referralService;
	
	@Autowired
	private VisitService visitService; 
	
	@Autowired
	private PatientService patientService; 
	
	@Autowired
	private DoctorService doctorService;   
	
	@Autowired
	private ReferralCenterService referralCenterService; 	
	
	
	// insert data into referral table
	@PostMapping("/register")
	public ResponseEntity<Referral> saveReferralEntity(@Valid @RequestBody ReferralDto referralDto){
		
		 Referral referral = new Referral();
		 
		 referral.setNote_type(referralDto.getNote_type());
		 referral.setReason(referralDto.getReason());
		 referral.setDetalis(referralDto.getDetalis());
		 referral.setCreated_at(LocalDateTime.now());
		 
		 Visit visit = visitService.getVisitById(referralDto.getVisitid());  
		 referral.setVisitid(visit);
		 
		 Patient patient = patientService.getPatientById(referralDto.getPatientid());  
		 referral.setPatientid(patient);
		 
		 Doctor doctor = doctorService.getDoctorById(referralDto.getDoctorid());  
		 referral.setDoctorid(doctor);
		 
		 ReferralCenter referral_Center = referralCenterService.getReferralCenterById(referralDto.getReferralCenterid());  
		 referral.setReferralCenterid(referral_Center);
		 
		 Referral saveReferral = referralService.saveReferral(referral);
		 
		 return new ResponseEntity<>(saveReferral, HttpStatus.CREATED);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Referral>> getAllDataFromReferral(){
		
		List<Referral> referral = referralService.getAllReferral();
		
		if(referral == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(referral , HttpStatus.OK);
				
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Referral> getReferralDataById(@PathVariable("id") int id, @RequestBody ReferralDto referralDto){
		
		Referral referral = referralService.getReferralById(id);
		
		if(referral == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		return new ResponseEntity<>(referral , HttpStatus.OK);
	}
	

	@PutMapping("/{id}")
	public ResponseEntity<Referral> updateDataFromReferralById(@PathVariable("id") int id,@Valid  @RequestBody ReferralDto referralDto){
		
		Referral referral = referralService.getReferralById(id);
		if(referral == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		referral.setNote_type(referralDto.getNote_type());
		 referral.setReason(referralDto.getReason());
		 referral.setDetalis(referralDto.getDetalis());
		 referral.setCreated_at(LocalDateTime.now());
		 
		 Visit visit = visitService.getVisitById(referralDto.getVisitid());
		 referral.setVisitid(visit);
		 
		 Patient patient = patientService.getPatientById(referralDto.getPatientid());  
		 referral.setPatientid(patient);
		 
		 Doctor doctor = doctorService.getDoctorById(referralDto.getDoctorid()); 
		 referral.setDoctorid(doctor);
		 
		 ReferralCenter referral_Center = referralCenterService.getReferralCenterById(referralDto.getReferralCenterid());
		 referral.setReferralCenterid(referral_Center);
		 
		 Referral updateReferral = referralService.saveReferral(referral);
		 
		 return new ResponseEntity<>(updateReferral, HttpStatus.OK);
		
	}
	
	

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteReferralIdFromTable(@PathVariable("id") int id){
		
		Referral referral = referralService.getReferralById(id);
		
		if(referral == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		referralService.deleteReferralById(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
		
	}

}
