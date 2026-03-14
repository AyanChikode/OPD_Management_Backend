package com.OPD_Management_Backend.OPD_Management_Backend.ServicesIMPLs;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Diagnostic;
import com.OPD_Management_Backend.OPD_Management_Backend.exception.ResourceNotFoundException;
import com.OPD_Management_Backend.OPD_Management_Backend.repositories.DiagnosticRepository;
import com.OPD_Management_Backend.OPD_Management_Backend.services.DiagnosticService;

@Service
@RequiredArgsConstructor
public class DiagnosticIMPL implements DiagnosticService {

    private final DiagnosticRepository repository;

    // ✅ CREATE
    @Override
    public Diagnostic saveDiagnostic(Diagnostic diagnostic) {
        return repository.save(diagnostic);
    }

    // ✅ READ ALL
    @Override
    public List<Diagnostic> getAllDiagnostic() {
        return repository.findAll();
    }

    // ✅ READ BY ID
    @Override
    public Diagnostic getDiagnosticById(int id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Diagnostic not found with id: " + id));
    }

    // ✅ DELETE
    @Override
    public void deleteDiagnosticById(int id) {

        Diagnostic diagnostic = getDiagnosticById(id); // reuse method
        repository.delete(diagnostic);
    }
}