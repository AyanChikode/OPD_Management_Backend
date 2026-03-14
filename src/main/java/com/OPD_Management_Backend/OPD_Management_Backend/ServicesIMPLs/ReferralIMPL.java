package com.OPD_Management_Backend.OPD_Management_Backend.ServicesIMPLs;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Referral;
import com.OPD_Management_Backend.OPD_Management_Backend.exception.ResourceNotFoundException;
import com.OPD_Management_Backend.OPD_Management_Backend.repositories.ReferralRepository;
import com.OPD_Management_Backend.OPD_Management_Backend.services.ReferralService;

@Service
@RequiredArgsConstructor
public class ReferralIMPL implements ReferralService {

    private final ReferralRepository repository;

    @Override
    public Referral saveReferral(Referral referral) {
        return repository.save(referral);
    }

    @Override
    public List<Referral> getAllReferral() {
        return repository.findAll();
    }

    @Override
    public Referral getReferralById(int id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Referral not found with id: " + id));
    }

    @Override
    public void deleteReferralById(int id) {
        Referral referral = getReferralById(id);
        repository.delete(referral);
    }
}