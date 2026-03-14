package com.OPD_Management_Backend.OPD_Management_Backend.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DoctorResponce {
	
	private int id;
	private String name;
	private String password;
	private String specialization;
	private String qulification;
	private String clinic_name;
	private String address;
	private String mobileNo;

}
