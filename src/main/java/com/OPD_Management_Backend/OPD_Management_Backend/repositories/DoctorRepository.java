package com.OPD_Management_Backend.OPD_Management_Backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

	boolean existsByemail(String email);   
	
	Optional<Doctor> findByEmail(String email); 
}
