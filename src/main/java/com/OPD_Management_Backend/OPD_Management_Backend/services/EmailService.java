package com.OPD_Management_Backend.OPD_Management_Backend.services;

import com.OPD_Management_Backend.OPD_Management_Backend.dtos.EmailRequestDto;

public interface EmailService {

	String sendEmail(EmailRequestDto emailRequest);

}
