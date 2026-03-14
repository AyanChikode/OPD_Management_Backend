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
@Table(name="medicines")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String medicine_name;
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "doctorId")
	@JsonIgnoreProperties(value = {"doctorid"} , allowSetters = true)
	private Doctor doctorid;

}
