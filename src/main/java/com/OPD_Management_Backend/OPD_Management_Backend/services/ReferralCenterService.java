package com.OPD_Management_Backend.OPD_Management_Backend.services;

import java.util.List;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.ReferralCenter;


public interface ReferralCenterService {

	ReferralCenter saveReferralCenter (ReferralCenter center);
	

	List<ReferralCenter> getAllReferralCenter();
	

	ReferralCenter getReferralCenterById(int id);

	
	void deleteReferralCenterById(int id);
}
