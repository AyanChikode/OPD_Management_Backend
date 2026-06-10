package com.OPD_Management_Backend.OPD_Management_Backend.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Admin {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(nullable = false, unique = true)
	private String email;
	private String password;
	private String mobileNo;
	@Enumerated(EnumType.STRING)
	private Role role = Role.ADMIN;
	@Column(length = 500)
	private String token;	
	private Integer emailOtp;
	private boolean isEmailVerify;
    private LocalDateTime otpExpiry;

	private LocalDateTime created_at;
	
	private LocalDateTime update_at;
}
