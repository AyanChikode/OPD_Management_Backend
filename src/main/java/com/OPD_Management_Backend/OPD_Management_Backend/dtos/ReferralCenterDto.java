package com.OPD_Management_Backend.OPD_Management_Backend.dtos;

import java.time.LocalDateTime;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Doctor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReferralCenterDto {

	@NotBlank(message = "name is required")
	private String name;
	@NotBlank(message = "type is required")
	private String type;
	@NotBlank(message = "contact_info is required")
	private String contact_info;
	@NotBlank(message = "address is required")
	private String address;
	@NotNull(message = "Id must be required")
	private int doctorid;
}
