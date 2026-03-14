package com.OPD_Management_Backend.OPD_Management_Backend.ServicesIMPLs;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Bill;
import com.OPD_Management_Backend.OPD_Management_Backend.exception.ResourceNotFoundException;
import com.OPD_Management_Backend.OPD_Management_Backend.repositories.BillRepository;
import com.OPD_Management_Backend.OPD_Management_Backend.services.BillService;

@Service
@RequiredArgsConstructor
public class BillIMPL implements BillService {

    private final BillRepository repository;

    @Override
    public Bill saveBill(Bill bill) {
        return repository.save(bill);
    }

    @Override
    public List<Bill> getAllBill() {
        return repository.findAll();
    }

    @Override
    public Bill getBillById(int id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Bill not found with id: " + id));
    }

    @Override
    public void deleteBillById(int id) {
        Bill bill = getBillById(id);
        repository.delete(bill);
    }
}