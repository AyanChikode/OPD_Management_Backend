package com.OPD_Management_Backend.OPD_Management_Backend.entities;

import java.math.BigDecimal;
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
@Table(name = "bills")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private BigDecimal consultation_fee;
	private String payment_status;
	private String payment_mode;
	private BigDecimal concession;
	private BigDecimal paid_amount;
	private BigDecimal total_amount;
	private BigDecimal pending_amount;
	private LocalDateTime created_at;
	
	@ManyToOne
	@JoinColumn(name = "visitId")
	@JsonIgnoreProperties(value = {"visitid"} , allowSetters = true)
	private Visit visitid;
}