package com.OPD_Management_Backend.OPD_Management_Backend.services;

import java.util.Random;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public class GenerateOtp {
	public int generateRandomOtp() {
		Random random = new Random();
		return 100000 + random.nextInt(900000); //6 digit OTP
	}
}
