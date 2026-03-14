package com.OPD_Management_Backend.OPD_Management_Backend.ServicesIMPLs;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.ReferralCenter;
import com.OPD_Management_Backend.OPD_Management_Backend.exception.ResourceNotFoundException;
import com.OPD_Management_Backend.OPD_Management_Backend.repositories.ReferralCenterRepository;
import com.OPD_Management_Backend.OPD_Management_Backend.services.ReferralCenterService;

@Service
@RequiredArgsConstructor
public class ReferralCenterIMPL implements ReferralCenterService {

    private final ReferralCenterRepository repository;

    @Override
    public ReferralCenter saveReferralCenter(ReferralCenter center) {
        return repository.save(center);
    }

    @Override
    public List<ReferralCenter> getAllReferralCenter() {
        return repository.findAll();
    }

    @Override
    public ReferralCenter getReferralCenterById(int id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("ReferralCenter not found with id: " + id));
    }

    @Override
    public void deleteReferralCenterById(int id) {
        ReferralCenter center = getReferralCenterById(id);
        repository.delete(center);
    }
}