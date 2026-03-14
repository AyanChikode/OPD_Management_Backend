package com.OPD_Management_Backend.OPD_Management_Backend.entities;

import java.time.LocalDate;
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
@Table(name="visits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate visitDate;
	private String complaints;
	private String diagnosis;
	private String advice;
	private String bp;
	private String pulse;
	private String saturation;
	private String temperature;
	private String respiration;
	private String sugar;
	private String fasting_sugar;
	private String pp_sugar;
	private String random_sugar;
	private String urea_creatinine;
	private String past_history;
	private String current_medication;
	private String additional_notes;
	private int weight;
	private String edema;
	private String pallor;
	private String jaundice;
	private String cvs;
	private String rs;
	private String pa;
	private String  cns;
	private String hb;
	private String ecg;
	private LocalDateTime followup_date;
	private LocalDateTime created_at;
	private LocalDateTime updates_at;
	
	@ManyToOne
	@JoinColumn(name = "patientId")
	@JsonIgnoreProperties(value = {"patientid"} , allowSetters = true)
	private Patient patientid; 
	
	@ManyToOne
	@JoinColumn(name = "doctorId")
	@JsonIgnoreProperties(value = {"doctorid"}, allowSetters = true)
	private Doctor doctorid;

}
