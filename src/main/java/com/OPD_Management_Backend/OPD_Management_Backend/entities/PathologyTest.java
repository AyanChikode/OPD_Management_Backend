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
@Table(name="pathologytest")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PathologyTest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String result;
	private String remarks;
	private String report_file;
	private LocalDateTime created_at;
	
	@ManyToOne
	@JoinColumn(name = "visitId")
	@JsonIgnoreProperties(value = {"visitid"}, allowSetters = true)
	private Visit visitid;
	
	
	@ManyToOne
	@JoinColumn(name = "test_master")
	@JsonIgnoreProperties(value = {"testmaster"} , allowSetters = true)
	private Test_Master testMasterid;
}
