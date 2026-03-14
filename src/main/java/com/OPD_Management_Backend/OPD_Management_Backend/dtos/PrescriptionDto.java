package com.OPD_Management_Backend.OPD_Management_Backend.dtos;

import java.time.LocalDateTime;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Medicine;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Visit;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PrescriptionDto {
	
	@NotBlank(message = "Dosage is required")
	private String dosage;
	@NotBlank(message = "durtion is required")
	private String durtion;
	@NotBlank(message = "instrucations is required")
	private String instrucations;
	@Min(value = 1, message = "Quantity must be at least 1")
	private int quality;
	@Min(value = 0, message = "Quantity must be at least 1")
	private int morning_dose;
	@Min(value = 0, message = "Quantity must be at least 1")
	private int afternoon_dose;
	@Min(value = 0, message = "Quantity must be at least 1")
	private int evening_dose;
	@Min(value = 1, message = "Quantity must be at least 1")
	private int duration_days;
	@Min(value = 1, message = "Quantity must be at least 1")
	private int total_quantity;
	@Size(max = 100, message = "Quantity note must be less than 100 characters")
	private String quantity_note;
	@NotBlank(message = "dose_qty quantity is required")
	private String dose_qty;
	@NotBlank(message = "dose_unit quantity is required")
	private String dose_unit;
	@NotNull(message = " ID is required")
	private int visitid;
	@NotNull(message = " ID is required")
	private int medicineid;


}
