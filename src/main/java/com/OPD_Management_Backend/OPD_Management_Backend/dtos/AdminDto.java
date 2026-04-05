package com.OPD_Management_Backend.OPD_Management_Backend.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AdminDto {
	
	@NotBlank(message = "name is required")
	@Size(min = 3,max = 50 ,message = "Name must be between 3–50 characters")
	private String name;
	
	@NotBlank(message = "Email is Required")
	@Email(message = "Enter Valid Email address")
	private String email;
	
	@NotBlank(message = "Password cannot be blank")
    @Size(min = 6, message = "Password must be at least 6 characters")
	private String password;
	
	@NotBlank(message = "Mobile number is required")
	@Pattern(regexp="^[0-9]{10}$",message = "Mobile number must be exactly 10 digits")
	private String mobileNo;
	
	private String token;

}
