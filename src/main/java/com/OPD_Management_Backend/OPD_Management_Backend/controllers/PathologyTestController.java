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

import com.OPD_Management_Backend.OPD_Management_Backend.dtos.PathologyTestDto;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.PathologyTest;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Test_Master;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Visit;
import com.OPD_Management_Backend.OPD_Management_Backend.repositories.PathologyTestRepository;
import com.OPD_Management_Backend.OPD_Management_Backend.services.PathologyTestService;
import com.OPD_Management_Backend.OPD_Management_Backend.services.Test_MasterService;
import com.OPD_Management_Backend.OPD_Management_Backend.services.VisitService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pathologytests")
public class PathologyTestController {

	@Autowired
	private PathologyTestService pathologyTestService;
	
	@Autowired
	private VisitService visitService; 
	
	@Autowired
	private Test_MasterService testsMasterService;
	
	
	@PostMapping("/register")
	public ResponseEntity<PathologyTest> savePathologyTest(@Valid @RequestBody PathologyTestDto pathologyTestDto){
		
		PathologyTest pathologyTest = new PathologyTest();
		
		pathologyTest.setResult(pathologyTestDto.getResult());
		pathologyTest.setRemarks(pathologyTestDto.getRemarks());
		pathologyTest.setReport_file(pathologyTestDto.getReport_file());
		pathologyTest.setCreated_at(LocalDateTime.now());
		
		
		// to get visit id show data 
		Visit visit = visitService.getVisitById(pathologyTestDto.getVisitid());
		pathologyTest.setVisitid(visit);
		
		
		// to get tests_master id or show data 
		Test_Master testsMaster = testsMasterService.getTest_MasterById(pathologyTestDto.getTestMasterid());
		pathologyTest.setTestMasterid(testsMaster);
		
		PathologyTest savePathologyTest = pathologyTestService.savePathologyTest(pathologyTest);
		
		return new ResponseEntity<>(savePathologyTest, HttpStatus.CREATED);
	}
	
	// get all data from pathology_test
	@GetMapping("/list")
	public ResponseEntity<List<PathologyTest>> getAllPathologyTest(){
		
		List<PathologyTest> pathologyTest = pathologyTestService.getAllPathologyTest();
		if(pathologyTest == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(pathologyTest, HttpStatus.OK);
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<PathologyTest> getSpecificDataFromPathology_TestUsingId(@PathVariable("id") int id){
		
		PathologyTest pathologyTest = pathologyTestService.getPathologyTestById(id);
		if(pathologyTest == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<>(pathologyTest, HttpStatus.OK);
	}
	
	// update data from pathology_Test using id
	@PutMapping("/update/{id}")
	public ResponseEntity<PathologyTest> updateDataFromPathology_Test(@PathVariable("id") int id,@Valid  @RequestBody PathologyTestDto pathology_TestDto){
		
		PathologyTest pathology_Test = pathologyTestService.getPathologyTestById(id);
		if(pathology_Test == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		pathology_Test.setResult(pathology_TestDto.getResult());
		pathology_Test.setRemarks(pathology_TestDto.getRemarks());
		pathology_Test.setReport_file(pathology_TestDto.getReport_file());
		pathology_Test.setCreated_at(LocalDateTime.now());
		
		// to get visit id show data 
		Visit visit = visitService.getVisitById(pathology_TestDto.getVisitid());
		pathology_Test.setVisitid(visit);
		
		// to get tests_master id or show data 
		Test_Master tests_Master = testsMasterService.getTest_MasterById(pathology_TestDto.getTestMasterid());
		pathology_Test.setTestMasterid(tests_Master);
		
		PathologyTest updatePathology_Test = pathologyTestService.savePathologyTest(pathology_Test);
		
		return new ResponseEntity<>(updatePathology_Test, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteSpecificIdFromPathology_Test(@PathVariable("id") int id){
		
		PathologyTest pathology_Test = pathologyTestService.getPathologyTestById(id);
		if(pathology_Test == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		pathologyTestService.deletePathologyTestById(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
