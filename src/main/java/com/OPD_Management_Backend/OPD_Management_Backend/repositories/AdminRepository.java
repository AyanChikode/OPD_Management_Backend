package com.OPD_Management_Backend.OPD_Management_Backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    boolean existsByEmail(String email);

    Optional<Admin> findByEmail(String email);
}
