package com.OPD_Management_Backend.OPD_Management_Backend.ServicesIMPLs;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Test_Master;
import com.OPD_Management_Backend.OPD_Management_Backend.exception.ResourceNotFoundException;
import com.OPD_Management_Backend.OPD_Management_Backend.repositories.Test_MasterRepository;
import com.OPD_Management_Backend.OPD_Management_Backend.services.Test_MasterService;

@Service
@RequiredArgsConstructor
public class Test_MasterIMPL implements Test_MasterService {

    private final Test_MasterRepository repository;

    @Override
    public Test_Master saveTest_Master(Test_Master master) {
        return repository.save(master);
    }

    @Override
    public List<Test_Master> getAllTest_Master() {
        return repository.findAll();
    }

    @Override
    public Test_Master getTest_MasterById(int id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Test_Master not found with id: " + id));
    }

    @Override
    public void deleteTest_MasterById(int id) {
        Test_Master master = getTest_MasterById(id);
        repository.delete(master);
    }
}