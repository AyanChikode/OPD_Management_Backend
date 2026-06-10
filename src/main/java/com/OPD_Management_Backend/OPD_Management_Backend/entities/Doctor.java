package com.OPD_Management_Backend.OPD_Management_Backend.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name= "doctors",
uniqueConstraints = {
		@UniqueConstraint(columnNames = "email"),
		@UniqueConstraint(columnNames = "mobileno")})  //table name is doctors in database.
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
	private String email;
	private String specialization;
	private String qulification;
	@Enumerated(EnumType.STRING)
	private Role role = Role.DOCTOR;
	private String clinic_name;
	private String address;
	private String mobileNo;
	@Column(length = 500)
	private String token;	private String status;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	
    private LocalDateTime otpExpiry;

	@OneToMany(
		    mappedBy = "doctorid",
		    cascade = CascadeType.ALL,
		    orphanRemoval = true
		)
		@JsonIgnore
		private List<Patient> patients;
	@Column(nullable = true)
	private Integer emailOtp;
	private boolean isEmailVerify;
	
	
	

	
	

}
