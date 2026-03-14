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
import lombok.ToString;

@Entity
@Table(name="receptions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reception {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String mobile_no;
	private String shift;
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "DoctorId")
	@JsonIgnoreProperties(value = {"doctorid"} , allowSetters = true)
	private Doctor doctorid;

}
