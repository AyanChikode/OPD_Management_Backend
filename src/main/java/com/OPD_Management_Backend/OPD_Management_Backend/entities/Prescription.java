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
@Table(name="prescriptions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String dosage;
	private String durtion;
	private String instrucations;
	private int quality;
	private LocalDateTime created_at;
	private int morning_dose;
	private int afternoon_dose;
	private int evening_dose;
	private int duration_days;
	private int total_quantity;
	private String quantity_note;
	private String dose_qty;
	private String dose_unit;
	
	@ManyToOne
	@JoinColumn(name = "visitId")
	@JsonIgnoreProperties(value = {"visitid"}, allowSetters = true)
	private Visit visitid;
	
	
	@ManyToOne
	@JoinColumn(name = "medicineId")
	@JsonIgnoreProperties(value = {"medicineid"}, allowSetters = true)
	private Medicine medicineid;

}
