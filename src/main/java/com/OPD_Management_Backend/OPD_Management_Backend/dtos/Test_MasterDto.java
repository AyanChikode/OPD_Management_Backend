package com.OPD_Management_Backend.OPD_Management_Backend.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Test_MasterDto {
	
	@NotBlank(message = "Test name is required")
	private String test_name;
	@NotBlank(message = "normal_range is required")
	private String normal_range;
	@NotBlank(message = "unit is required")
	private String unit;
	@NotNull(message = "Id must be required")
	private int doctorid;

}
