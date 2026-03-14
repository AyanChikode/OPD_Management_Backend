package com.OPD_Management_Backend.OPD_Management_Backend.ServicesIMPLs;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Reception;
import com.OPD_Management_Backend.OPD_Management_Backend.exception.ResourceNotFoundException;
import com.OPD_Management_Backend.OPD_Management_Backend.repositories.ReceptionRepository;
import com.OPD_Management_Backend.OPD_Management_Backend.services.ReceptionService;

@Service
@RequiredArgsConstructor
public class ReceptionIMPL implements ReceptionService {

    private final ReceptionRepository repository;

    // ✅ CREATE
    @Override
    public Reception saveReception(Reception reception) {
        return repository.save(reception);
    }

    // ✅ READ ALL
    @Override
    public List<Reception> getAllReception() {
        return repository.findAll();
    }

    // ✅ READ BY ID
    @Override
    public Reception getReceptionById(int id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Reception not found with id: " + id));
    }

    // ✅ DELETE
    @Override
    public void deleteReceptionById(int id) {
        Reception reception = getReceptionById(id);
        repository.delete(reception);
    }
}