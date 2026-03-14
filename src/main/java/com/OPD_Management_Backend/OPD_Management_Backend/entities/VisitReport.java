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
@Table(name="visitreports")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VisitReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String file_name;
	private String file_url;
	private String file_type;
	private LocalDateTime created_at;
	
	
	@ManyToOne
	@JoinColumn(name = "visitid")
	@JsonIgnoreProperties(value = {"visitid"}, allowSetters = true)
	private Visit visitid;

}
