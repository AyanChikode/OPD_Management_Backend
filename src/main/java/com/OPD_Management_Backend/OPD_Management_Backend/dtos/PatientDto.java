package com.OPD_Management_Backend.OPD_Management_Backend.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PatientDto {

	@NotBlank(message = " name is required")
	private String patient_name;
	@Min(value = 0, message="age cannot be negative")
	private int age;
	@NotBlank(message = " gender is required")
	private String gender;
	@NotNull(message = "mobile No is required")
	private String mobileNo;
	@NotBlank(message = " address is required")
	private String address;
	@NotBlank(message = " blood_group is required")
	private String blood_group;
	@NotBlank(message = " smoking is required")
	private String height;
	@NotBlank(message = " smoking is required")
	private String smoking;
	@NotBlank(message = " alcohol is required")
	private String alcohol;
	@NotBlank(message = " tobacco is required")
	private String tobacco;
	@NotNull(message = "id no is required")
	private int doctor_id;
	
	
}
