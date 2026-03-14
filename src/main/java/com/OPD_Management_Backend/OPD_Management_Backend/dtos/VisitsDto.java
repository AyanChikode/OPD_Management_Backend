package com.OPD_Management_Backend.OPD_Management_Backend.dtos;

import java.time.LocalDateTime;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Doctor;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Patient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class VisitsDto {
	
	private LocalDateTime visitDate;
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
	
	private int patientid;
	private int doctorid;

}
