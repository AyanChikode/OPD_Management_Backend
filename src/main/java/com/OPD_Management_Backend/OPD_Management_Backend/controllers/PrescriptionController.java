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

import com.OPD_Management_Backend.OPD_Management_Backend.dtos.PrescriptionDto;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Medicine;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Prescription;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Visit;
import com.OPD_Management_Backend.OPD_Management_Backend.services.MedicineService;
import com.OPD_Management_Backend.OPD_Management_Backend.services.PrescriptionService;
import com.OPD_Management_Backend.OPD_Management_Backend.services.VisitService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {
	
	@Autowired
	private PrescriptionService prescriptionService;
	
	@Autowired
	private VisitService visitService;
	
	@Autowired
	private MedicineService medicineService;
	
	
	@PostMapping("/register")
	public ResponseEntity<Prescription> savePrescriptionEntity(@Valid @RequestBody PrescriptionDto prescriptionDto){
		
		
		Prescription prescription = new Prescription();
		
		prescription.setDosage(prescriptionDto.getDosage());
		prescription.setDurtion(prescriptionDto.getDurtion());
		prescription.setInstrucations(prescriptionDto.getInstrucations());
		prescription.setQuality(prescriptionDto.getQuality());
		prescription.setCreated_at(LocalDateTime.now());
		prescription.setMorning_dose(prescriptionDto.getMorning_dose());
		prescription.setAfternoon_dose(prescriptionDto.getAfternoon_dose());
		prescription.setEvening_dose(prescriptionDto.getAfternoon_dose());
		prescription.setDuration_days(prescriptionDto.getDuration_days());
		prescription.setTotal_quantity(prescriptionDto.getTotal_quantity());
		prescription.setQuantity_note(prescriptionDto.getQuantity_note());
		prescription.setDose_qty(prescriptionDto.getDose_qty());
		prescription.setDose_unit(prescriptionDto.getDose_unit());
		
		Visit visit = visitService.getVisitById(prescriptionDto.getVisitid());
		
		Medicine medicine = medicineService.getMedicineById(prescriptionDto.getMedicineid());
		
		prescription.setVisitid(visit);
		prescription.setMedicineid(medicine);
		
		Prescription savePrescription = prescriptionService.savePrescription(prescription);
		
		return new ResponseEntity<>(savePrescription, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Prescription>>  getAllPrescriptionFromTable(){
		
		List<Prescription> prescription = prescriptionService.getAllPrescription();
		
		if(prescription == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(prescription, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Prescription> getPrescriptionByIdFromTable(@PathVariable("id") int id){
		
		Prescription prescription = prescriptionService.getPrescriptionById(id);
		if(prescription == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(prescription, HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Prescription> updatePrescriptionById(@PathVariable("id") int id,@Valid  @RequestBody PrescriptionDto  prescriptionDto){
		
		
		Prescription prescription = prescriptionService.getPrescriptionById(id);
		
		if(prescription == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		prescription.setDosage(prescriptionDto.getDosage());
		prescription.setDurtion(prescriptionDto.getDurtion());
		prescription.setInstrucations(prescriptionDto.getInstrucations());
		prescription.setQuality(prescriptionDto.getQuality());
		prescription.setCreated_at(LocalDateTime.now());
		prescription.setMorning_dose(prescriptionDto.getMorning_dose());
		prescription.setAfternoon_dose(prescriptionDto.getAfternoon_dose());
		prescription.setEvening_dose(prescriptionDto.getAfternoon_dose());
		prescription.setDuration_days(prescriptionDto.getDuration_days());
		prescription.setTotal_quantity(prescriptionDto.getTotal_quantity());
		prescription.setQuantity_note(prescriptionDto.getQuantity_note());
		prescription.setDose_qty(prescriptionDto.getDose_qty());
		prescription.setDose_unit(prescriptionDto.getDose_unit());
		
		Visit visit = visitService.getVisitById(prescriptionDto.getVisitid());
		
		Medicine medicine = medicineService.getMedicineById(prescriptionDto.getMedicineid());
		
		prescription.setVisitid(visit);
		prescription.setMedicineid(medicine);
		
		Prescription updatePrescription = prescriptionService.savePrescription(prescription);
		return new ResponseEntity<>(updatePrescription, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deletePrescriptionUsingId(@PathVariable("id") int id){
		
		Prescription prescription = prescriptionService.getPrescriptionById(id);
		
		if(prescription == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		prescriptionService.deletePrescriptionById(id);
		
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}

}
