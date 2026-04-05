package com.OPD_Management_Backend.OPD_Management_Backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Boolean existsByEmail(String email);
	
	Optional<Admin>  findByEmail(String email);
}
