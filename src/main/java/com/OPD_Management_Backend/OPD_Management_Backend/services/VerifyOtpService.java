package com.OPD_Management_Backend.OPD_Management_Backend.services;

import com.OPD_Management_Backend.OPD_Management_Backend.dtos.VerifyEmailOtpDto;
import com.OPD_Management_Backend.OPD_Management_Backend.response.EmailResponse;

public interface VerifyOtpService {
	
	    EmailResponse verifyEmailOtp(VerifyEmailOtpDto verifyEmailOtpDto);
	}
