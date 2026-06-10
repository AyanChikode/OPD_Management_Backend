package com.OPD_Management_Backend.OPD_Management_Backend.dtos;

import lombok.Data;

@Data
public class VerifyEmailOtpDto {

	private String email;
	private Integer otp;
}
