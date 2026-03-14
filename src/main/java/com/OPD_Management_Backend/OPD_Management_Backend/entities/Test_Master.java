package com.OPD_Management_Backend.OPD_Management_Backend.entities;

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
@Table(name="testmasters")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test_Master {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String test_name;
	private String normal_range;
	private String unit;
	
	@ManyToOne
	@JoinColumn(name = "doctorId")
	@JsonIgnoreProperties(value = {"doctorid"}, allowSetters = true)
	private Doctor doctorid;

}
