package com.OPD_Management_Backend.OPD_Management_Backend.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class DiagnosticDto {
	@NotBlank (message = "Name is required")
	private String name;
	
	private LocalDateTime created_at;
	
	@NotNull(message = "Id must be required")
	private int visitid;
	
	@NotNull(message = "Id must be required")
	private int doctorid;


}
