package com.OPD_Management_Backend.OPD_Management_Backend.ServicesIMPLs;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Patient;
import com.OPD_Management_Backend.OPD_Management_Backend.exception.ResourceNotFoundException;
import com.OPD_Management_Backend.OPD_Management_Backend.repositories.PatientRepository;
import com.OPD_Management_Backend.OPD_Management_Backend.services.PatientService;

@Service
@RequiredArgsConstructor
public class PatientIMPL implements PatientService {

    private final PatientRepository repository;

    @Override
    public Patient savePatient(Patient patient) {
        return repository.save(patient);
    }

    @Override
    public List<Patient> getAllPatient() {
        return repository.findAll();
    }

    @Override
    public Patient getPatientById(int id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Patient not found with id: " + id));
    }

    @Override
    public void deletePatientById(int id) {
        Patient patient = getPatientById(id);
        repository.delete(patient);
    }
}