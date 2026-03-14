package com.OPD_Management_Backend.OPD_Management_Backend.ServicesIMPLs;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Doctor;
import com.OPD_Management_Backend.OPD_Management_Backend.exception.ResourceNotFoundException;
import com.OPD_Management_Backend.OPD_Management_Backend.repositories.DoctorRepository;
import com.OPD_Management_Backend.OPD_Management_Backend.services.DoctorService;

@Service
@RequiredArgsConstructor
public class DoctorIMPL implements DoctorService {

    private final DoctorRepository repository;

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return repository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctor() {
        return repository.findAll();
    }

    @Override
    public Doctor getDoctorById(int id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Doctor not found with id: " + id));
    }

    @Override
    public void deleteDoctorById(int id) {
        Doctor doctor = getDoctorById(id);
        repository.delete(doctor);
    }
}