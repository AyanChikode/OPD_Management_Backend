package com.OPD_Management_Backend.OPD_Management_Backend.services;

import java.util.List;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Bill;


public interface BillService {

		// to save/ insert data in doctors table
		Bill saveBill (Bill bill);
		
		// get all doctor data from database
		List<Bill> getAllBill();
		
		// get doctor by their id
		Bill getBillById(int id);
		
		// delete doctor By their Id
		void deleteBillById(int id);
}
