package com.OPD_Management_Backend.OPD_Management_Backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.ReferralCenter;

@Repository
public interface ReferralCenterRepository extends JpaRepository<ReferralCenter, Integer> {

}
