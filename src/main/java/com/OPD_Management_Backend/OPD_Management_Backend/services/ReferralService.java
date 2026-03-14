package com.OPD_Management_Backend.OPD_Management_Backend.services;

import java.util.List;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Referral;


public interface ReferralService {

		// to save/ insert data in doctors table
		Referral saveReferral (Referral referral);
		
		// get all doctor data from database
		List<Referral> getAllReferral();
		
		// get doctor by their id
		Referral getReferralById(int id);
		
		// delete doctor By their Id
		void deleteReferralById(int id);
}
