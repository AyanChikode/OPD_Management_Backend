package com.OPD_Management_Backend.OPD_Management_Backend.ServicesIMPLs;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Visit;
import com.OPD_Management_Backend.OPD_Management_Backend.exception.ResourceNotFoundException;
import com.OPD_Management_Backend.OPD_Management_Backend.repositories.VisitRepository;
import com.OPD_Management_Backend.OPD_Management_Backend.services.VisitService;

@Service
@RequiredArgsConstructor
public class VisitIMPL implements VisitService {

    private final VisitRepository repository;

    @Override
    public Visit saveVisit(Visit visit) {
        return repository.save(visit);
    }

    @Override
    public List<Visit> getAllVisit() {
        return repository.findAll();
    }

    @Override
    public Visit getVisitById(int id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Visit not found with id: " + id));
    }

    @Override
    public void deleteVisitById(int id) {
        Visit visit = getVisitById(id);
        repository.delete(visit);
    }
}