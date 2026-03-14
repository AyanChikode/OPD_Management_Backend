package com.OPD_Management_Backend.OPD_Management_Backend.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name= "doctors")  //table name is doctors in database.
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Doctor {
	
	
	@Id 						// ID is Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // For Id auto increatement
	private int id;
	private String name;
	private String password;
	private String specialization;
	private String qulification;
	private String clinic_name;
	private String address;
	private String mobileNo;
	private String token;
	private String status;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	
	
	

	
	

}
