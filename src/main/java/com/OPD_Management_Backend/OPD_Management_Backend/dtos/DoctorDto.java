package com.OPD_Management_Backend.OPD_Management_Backend.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DoctorDto {
	
	// Front_End Data temporary Store in Dto
	@NotBlank(message = "Name is required")
	private String name;
	@NotBlank(message = "password is required")
	private String password;
	@NotBlank(message = "Email is required")
	@Email(message = "Email must be valid")
	private String email;
	@NotBlank(message = "specialization is required")
	private String specialization;
	@NotBlank(message = "qulification is required")
	private String qulification;
	@NotBlank(message = "clinic_name is required")
	private String clinic_name;
	@NotBlank(message = "address is required")
	private String address;
	@NotBlank(message = "mobileNo is required")
	private String mobileNo;
	private String token;
	@NotBlank(message = "status is required")
	private String status;
	
	private String role; 
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	
	
	
	
	
	

}
