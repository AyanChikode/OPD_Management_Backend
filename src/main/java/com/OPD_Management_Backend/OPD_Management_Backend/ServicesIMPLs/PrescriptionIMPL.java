package com.OPD_Management_Backend.OPD_Management_Backend.ServicesIMPLs;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Prescription;
import com.OPD_Management_Backend.OPD_Management_Backend.exception.ResourceNotFoundException;
import com.OPD_Management_Backend.OPD_Management_Backend.repositories.PrescriptionRepository;
import com.OPD_Management_Backend.OPD_Management_Backend.services.PrescriptionService;

@Service
@RequiredArgsConstructor
public class PrescriptionIMPL implements PrescriptionService {

    private final PrescriptionRepository repository;

    // ✅ CREATE
    @Override
    public Prescription savePrescription(Prescription prescription) {
        return repository.save(prescription);
    }

    // ✅ READ ALL
    @Override
    public List<Prescription> getAllPrescription() {
        return repository.findAll();
    }

    // ✅ READ BY ID
    @Override
    public Prescription getPrescriptionById(int id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Prescription not found with id: " + id));
    }

    // ✅ DELETE
    @Override
    public void deletePrescriptionById(int id) {
        Prescription prescription = getPrescriptionById(id);
        repository.delete(prescription);
    }
}