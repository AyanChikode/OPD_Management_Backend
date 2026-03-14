package com.OPD_Management_Backend.OPD_Management_Backend.ServicesIMPLs;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.VisitReport;
import com.OPD_Management_Backend.OPD_Management_Backend.exception.ResourceNotFoundException;
import com.OPD_Management_Backend.OPD_Management_Backend.repositories.VisitReportRepository;
import com.OPD_Management_Backend.OPD_Management_Backend.services.VisitReportService;

@Service
@RequiredArgsConstructor
public class VisitReportIMPL implements VisitReportService {

    private final VisitReportRepository repository;

    @Override
    public VisitReport saveVisitReport(VisitReport visitReport) {
        return repository.save(visitReport);
    }

    @Override
    public List<VisitReport> getAllVisitReport() {
        return repository.findAll();
    }

    @Override
    public VisitReport getVisitReportById(int id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("VisitReport not found with id: " + id));
    }

    @Override
    public void deleteVisitReportById(int id) {
        VisitReport visitReport = getVisitReportById(id);
        repository.delete(visitReport);
    }
}