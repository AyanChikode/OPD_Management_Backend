package com.OPD_Management_Backend.OPD_Management_Backend.dtos;

import lombok.Data;

@Data
public class EmailRequest {

	private String to;
	private String subject;
	private String message;
}
