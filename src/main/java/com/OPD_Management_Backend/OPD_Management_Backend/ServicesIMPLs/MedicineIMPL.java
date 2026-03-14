package com.OPD_Management_Backend.OPD_Management_Backend.ServicesIMPLs;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Medicine;
import com.OPD_Management_Backend.OPD_Management_Backend.exception.ResourceNotFoundException;
import com.OPD_Management_Backend.OPD_Management_Backend.repositories.MedicineRepository;
import com.OPD_Management_Backend.OPD_Management_Backend.services.MedicineService;

@Service
@RequiredArgsConstructor
public class MedicineIMPL implements MedicineService {

    private final MedicineRepository repository;

    @Override
    public Medicine saveMedicine(Medicine medicine) {
        return repository.save(medicine);
    }

    @Override
    public List<Medicine> getAllMedicine() {
        return repository.findAll();
    }

    @Override
    public Medicine getMedicineById(int id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Medicine not found with id: " + id));
    }

    @Override
    public void deleteMedicineById(int id) {
        Medicine medicine = getMedicineById(id);
        repository.delete(medicine);
    }
}