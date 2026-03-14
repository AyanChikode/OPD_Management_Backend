package com.OPD_Management_Backend.OPD_Management_Backend.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MedicineDto {

	@NotBlank(message = "Medicine name is required")
	private String medicine_name;
	@NotBlank(message = "type name is required")
	private String type;
	@NotNull(message = "Id must be required")
	private int doctor_id;

}
