package com.OPD_Management_Backend.OPD_Management_Backend.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Referral;

@Repository
public interface ReferralRepository extends JpaRepository<Referral, Integer> {

}
