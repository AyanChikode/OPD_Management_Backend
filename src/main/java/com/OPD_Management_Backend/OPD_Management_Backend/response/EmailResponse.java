package com.OPD_Management_Backend.OPD_Management_Backend.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmailResponse {
	
	private Boolean success;
	
	
	private String message;

}
