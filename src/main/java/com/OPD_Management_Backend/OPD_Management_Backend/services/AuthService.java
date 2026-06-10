package com.OPD_Management_Backend.OPD_Management_Backend.services;

import com.OPD_Management_Backend.OPD_Management_Backend.dtos.LoginRequestDto;
import com.OPD_Management_Backend.OPD_Management_Backend.response.JwtResponse;

public interface AuthService {
	 	
		JwtResponse doctorLogin(LoginRequestDto loginRequestDto);
	    
	    JwtResponse adminLogin(LoginRequestDto loginRequestDto);
	    
	    JwtResponse receptionLogin(LoginRequestDto loginRequestDto);
}
