package com.OPD_Management_Backend.OPD_Management_Backend.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReceptionResponce {

	private int id;
	private String name;
	private String email;
	private String mobile_no;
	private String shift;
	private int doctorid;
}
