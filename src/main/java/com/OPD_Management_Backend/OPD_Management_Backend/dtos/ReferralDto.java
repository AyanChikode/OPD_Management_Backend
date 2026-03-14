package com.OPD_Management_Backend.OPD_Management_Backend.dtos;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class ReferralDto {
	@NotBlank(message = "Note type is required")
	private String note_type;
	@NotBlank(message = "Note type is required")
	private String reason;
	@NotBlank(message = "Note type is required")
	private String detalis;
	
	@NotNull(message = "Id must be required")
	private int visitid;
	@NotNull(message = "Id must be required")
	private int patientid;
	@NotNull(message = "Id must be required")
	private int doctorid;
	@NotNull(message = "Id must be required")
	private int referralCenterid;

}
