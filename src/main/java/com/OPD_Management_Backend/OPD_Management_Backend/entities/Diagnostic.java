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
import lombok.ToString;

@Entity
@Table(name="diagnostics")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Diagnostic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private LocalDateTime created_at;
	
	@ManyToOne
	@JoinColumn(name = ("visitId"))
	@JsonIgnoreProperties(value = {"visitid"} , allowSetters = true)
	private Visit visitid;
	
	
	@ManyToOne
	@JoinColumn(name = ("doctorId"))
	@JsonIgnoreProperties(value = {"doctorid"}, allowSetters = true)
	private Doctor doctorid;

}
