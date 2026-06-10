package com.OPD_Management_Backend.OPD_Management_Backend.controllers;

import java.time.LocalDate;
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

import com.OPD_Management_Backend.OPD_Management_Backend.dtos.VisitsDto;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Doctor;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Patient;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Visit;
import com.OPD_Management_Backend.OPD_Management_Backend.services.DoctorService;
import com.OPD_Management_Backend.OPD_Management_Backend.services.PatientService;
import com.OPD_Management_Backend.OPD_Management_Backend.services.VisitService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/visits")
@CrossOrigin(origins = "http://localhost:5173")

public class VisitController {
	
	@Autowired
	private VisitService visitservice;
	
	@Autowired
	private PatientService patientservice;
	
	@Autowired
	private DoctorService doctorservice;
	
	@PostMapping("/register")
	public ResponseEntity<Visit> saveVisitEntity(@Valid @RequestBody VisitsDto Dto){
		
		Visit visit = new Visit();
		visit.setVisitDate(LocalDate.now());
		visit.setComplaints(Dto.getComplaints());
		visit.setDiagnosis(Dto.getDiagnosis());
		visit.setAdvice(Dto.getAdvice());
		visit.setBp(Dto.getBp());
		visit.setPulse(Dto.getPulse());
		visit.setSaturation(Dto.getSaturation());
		visit.setTemperature(Dto.getTemperature());
		visit.setRespiration(Dto.getRespiration());
		visit.setSugar(Dto.getSugar());
		visit.setFasting_sugar(Dto.getFasting_sugar());
		visit.setPp_sugar(Dto.getPp_sugar());
		visit.setRandom_sugar(Dto.getRandom_sugar());
		visit.setUrea_creatinine(Dto.getUrea_creatinine());
		visit.setPast_history(Dto.getPast_history());
		visit.setCurrent_medication(Dto.getCurrent_medication());
		visit.setAdditional_notes(Dto.getAdditional_notes());
		visit.setWeight(Dto.getWeight());
		visit.setEdema(Dto.getEdema());
		visit.setPallor(Dto.getPallor());
		visit.setJaundice(Dto.getJaundice());
		visit.setCvs(Dto.getCvs());
		visit.setRs(Dto.getRs());
		visit.setPa(Dto.getPa());
		visit.setCns(Dto.getCns());
		visit.setHb(Dto.getHb());
		visit.setEcg(Dto.getEcg());
		visit.setFollowup_date(LocalDateTime.now());
		visit.setCreated_at(LocalDateTime.now());

		

		Patient patient = patientservice.getPatientById(Dto.getPatientid());
		

		Doctor doctor = doctorservice.getDoctorById(Dto.getDoctorid());
		
		visit.setPatientid(patient);
		visit.setDoctorid(doctor);
		
		Visit saveVisit = visitservice.saveVisit(visit);
		
		return new ResponseEntity<>(saveVisit, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Visit>> getAllVisitData(){
		
		List<Visit> visit = visitservice.getAllVisit();
		
		if(visit == null) {
			return new ResponseEntity<>(HttpStatus.FOUND);
		}
		
		return new ResponseEntity<>(visit, HttpStatus.OK);
				
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Visit> getVisitByIdFromTable(@PathVariable("id") int id){
		
		Visit visit = visitservice.getVisitById(id);
		
		if(visit == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(visit, HttpStatus.OK);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Visit>  upateVisitId(@PathVariable("id") int id,@Valid  @RequestBody VisitsDto Dto){
		Visit visit = visitservice.getVisitById(id);
		
		if(visit == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		visit.setComplaints(Dto.getComplaints());
		visit.setDiagnosis(Dto.getDiagnosis());
		visit.setAdvice(Dto.getAdvice());
		visit.setBp(Dto.getBp());
		visit.setPulse(Dto.getPulse());
		visit.setSaturation(Dto.getSaturation());
		visit.setTemperature(Dto.getTemperature());
		visit.setRespiration(Dto.getRespiration());
		visit.setSugar(Dto.getSugar());
		visit.setFasting_sugar(Dto.getFasting_sugar());
		visit.setPp_sugar(Dto.getPp_sugar());
		visit.setRandom_sugar(Dto.getRandom_sugar());
		visit.setUrea_creatinine(Dto.getUrea_creatinine());
		visit.setPast_history(Dto.getPast_history());
		visit.setCurrent_medication(Dto.getCurrent_medication());
		visit.setAdditional_notes(Dto.getAdditional_notes());
		visit.setWeight(Dto.getWeight());
		visit.setEdema(Dto.getEdema());
		visit.setPallor(Dto.getPallor());
		visit.setJaundice(Dto.getJaundice());
		visit.setCvs(Dto.getCvs());
		visit.setRs(Dto.getRs());
		visit.setPa(Dto.getPa());
		visit.setCns(Dto.getCns());
		visit.setHb(Dto.getHb());
		visit.setEcg(Dto.getEcg());
		visit.setFollowup_date(Dto.getFollowup_date());
		visit.setUpdates_at(LocalDateTime.now());
		
		// Patient Id / Info Using Patient Class and methods
		Patient patient = patientservice.getPatientById(Dto.getPatientid());
		
		// Doctor Id / Info Using Doctor Class and methods
		Doctor doctor = doctorservice.getDoctorById(Dto.getDoctorid());
		
		visit.setPatientid(patient);
		visit.setDoctorid(doctor);
		
		Visit saveVisit = visitservice.saveVisit(visit);
		
		return new ResponseEntity<>(saveVisit, HttpStatus.CREATED);
		
	
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Visit> getVisitById(@PathVariable("id") int id){
		
		Visit visit = visitservice.getVisitById(id);
		
		if(visit == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		visitservice.deleteVisitById(id);
		
		return new ResponseEntity<>(visit, HttpStatus.OK);
		
	}
	

}
