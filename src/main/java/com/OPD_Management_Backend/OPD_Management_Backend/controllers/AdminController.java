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
import org.springframework.security.crypto.password.PasswordEncoder;

import com.OPD_Management_Backend.OPD_Management_Backend.dtos.AdminDto;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Admin;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Role;
import com.OPD_Management_Backend.OPD_Management_Backend.services.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminController {

	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
public ResponseEntity<?> saveAdminEntity(
        @Valid @RequestBody AdminDto adminDto) {

    if (adminService.existsByEmail(adminDto.getEmail())) {

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Email already exists");
    }

    Admin admin = new Admin();

    admin.setName(adminDto.getName());
    admin.setEmail(adminDto.getEmail());
    admin.setMobileNo(adminDto.getMobileNo());
    admin.setToken(adminDto.getToken());
    admin.setPassword(
            passwordEncoder.encode(adminDto.getPassword()));
    admin.setCreated_at(LocalDateTime.now());
    admin.setUpdate_at(LocalDateTime.now());
    admin.setRole(Role.ADMIN);

    Admin saveAdmin = adminService.saveAdmin(admin);

    return new ResponseEntity<>(saveAdmin,
            HttpStatus.CREATED);
}
	
	
	
	@GetMapping("/list")
	public ResponseEntity<List<Admin>> getAllAdmin(){
		
		List<Admin> admin = adminService.getAllAdmin();
		
		if(admin == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(admin ,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Admin> getAdminUsingId(@PathVariable("id") int id){
		
		Admin admin = adminService.getAdminById(id);
		
		if(admin == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(admin, HttpStatus.OK);
				
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Admin> updateAdminUsingId(@PathVariable("id") int id , @Valid @RequestBody AdminDto adminDto){
		
		Admin admin = adminService.getAdminById(id);
		
		if(admin == null) {
				
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			admin.setName(adminDto.getName());
			admin.setEmail(adminDto.getEmail());
			admin.setMobileNo(adminDto.getMobileNo());
			admin.setToken(adminDto.getToken());
			admin.setPassword(passwordEncoder.encode(adminDto.getPassword()));
			admin.setCreated_at(LocalDateTime.now());
			admin.setUpdate_at(LocalDateTime.now());
			
			Admin updateAdmin = adminService.saveAdmin(admin);
			
			return new ResponseEntity<>(updateAdmin, HttpStatus.OK);
	}
		
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Admin>  deleteAdminUsingId(@PathVariable("id") int id){
		
		Admin admin = adminService.getAdminById(id);
		
		if(admin ==  null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		adminService.deleteAdmin(id);
		
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	
}
