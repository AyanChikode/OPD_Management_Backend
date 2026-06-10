package com.OPD_Management_Backend.OPD_Management_Backend.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString  

public class JwtResponse {
	
	private String token;
	private String role;
	private Object data;
}
