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

import com.OPD_Management_Backend.OPD_Management_Backend.dtos.BillDto;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Bill;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Visit;
import com.OPD_Management_Backend.OPD_Management_Backend.services.BillService;
import com.OPD_Management_Backend.OPD_Management_Backend.services.VisitService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bills")
@CrossOrigin(origins = "http://localhost:5173")
public class BillController {
	
	@Autowired
	private BillService billService ;
	
	@Autowired
	private VisitService visitService;
	
	
	@PostMapping("/register")
	public ResponseEntity<Bill> saveBill(@Valid @RequestBody BillDto billDto){
		
		Bill bill = new Bill();
		bill.setConsultation_fee(billDto.getConsultation_fee());
		bill.setPayment_status(billDto.getPayment_status());
		bill.setPayment_mode(billDto.getPayment_mode());
		bill.setConcession(billDto.getConcession());
		bill.setPaid_amount(billDto.getPaid_amount());
		bill.setTotal_amount(billDto.getTotal_amount());
		bill.setPending_amount(billDto.getPending_amount());
		bill.setCreated_at(LocalDateTime.now());
		
		Visit visit = visitService.getVisitById(billDto.getVisitid());
		
		bill.setVisitid(visit);
		
		Bill saveBill = billService.saveBill(bill);
		
		return new ResponseEntity<>(saveBill , HttpStatus.CREATED);
	}
	
	
	@GetMapping("/list")
	public ResponseEntity<List<Bill>> getAllBill(){
		
		List<Bill> bill = billService.getAllBill();
		
		if(bill == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(bill , HttpStatus.OK);
				
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Bill> getDataFromBillTableUsingId(@PathVariable("id") int id){
		
		Bill bill = billService.getBillById(id);
		if(bill == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(bill, HttpStatus.OK);
	}
	
	

	@PutMapping("/{id}")
	public ResponseEntity<Bill> updateSpecificId(@PathVariable("id") int id,@Valid  @RequestBody BillDto billDto){
		
		Bill bill = billService.getBillById(id);
		if(bill == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
		
		bill.setConsultation_fee(billDto.getConsultation_fee());
		bill.setPayment_status(billDto.getPayment_status());
		bill.setPayment_mode(billDto.getPayment_mode());
		bill.setConcession(billDto.getConcession());
		bill.setPaid_amount(billDto.getPaid_amount());
		bill.setTotal_amount(billDto.getTotal_amount());
		bill.setPending_amount(billDto.getPending_amount());
		bill.setCreated_at(LocalDateTime.now());
		
		
 
		Visit visit = visitService.getVisitById(billDto.getVisitid());
		
		bill.setVisitid(visit);
		
		Bill updateBill = billService.saveBill(bill);
		
		return new ResponseEntity<>(updateBill, HttpStatus.OK);
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSpecificIdFromBill(@PathVariable("id") int id){
		
		Bill bill = billService.getBillById(id);
		if(bill == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		billService.deleteBillById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}

