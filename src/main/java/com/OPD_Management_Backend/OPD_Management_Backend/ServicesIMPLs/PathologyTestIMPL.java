package com.OPD_Management_Backend.OPD_Management_Backend.ServicesIMPLs;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.PathologyTest;
import com.OPD_Management_Backend.OPD_Management_Backend.exception.ResourceNotFoundException;
import com.OPD_Management_Backend.OPD_Management_Backend.repositories.PathologyTestRepository;
import com.OPD_Management_Backend.OPD_Management_Backend.services.PathologyTestService;

@Service
@RequiredArgsConstructor
public class PathologyTestIMPL implements PathologyTestService {

    private final PathologyTestRepository repository;

    @Override
    public PathologyTest savePathologyTest(PathologyTest test) {
        return repository.save(test);
    }

    @Override
    public List<PathologyTest> getAllPathologyTest() {
        return repository.findAll();
    }

    @Override
    public PathologyTest getPathologyTestById(int id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("PathologyTest not found with id: " + id));
    }

    @Override
    public void deletePathologyTestById(int id) {
        PathologyTest test = getPathologyTestById(id);
        repository.delete(test);
    }
}