package com.OPD_Management_Backend.OPD_Management_Backend.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;	
	private String patient_name;
	private int age;
	private String gender;
	private String mobileNo;
	private String address;
	private String blood_group;
	private String height;
	private String smoking;
	private String alcohol;
	private String tobacco;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;

	
	@ManyToOne
	@JoinColumn(name = "doctorId")
	@JsonIgnoreProperties(value = {"doctorid"} , allowSetters = true)
	private Doctor doctorid;
	
	

}
