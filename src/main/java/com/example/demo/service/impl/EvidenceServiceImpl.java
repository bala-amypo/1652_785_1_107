package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DamageClaim;
import com.example.demo.model.Evidence;
import com.example.demo.repository.DamageClaimRepository;
import com.example.demo.repository.EvidenceRepository;
import com.example.demo.service.EvidenceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EvidenceServiceImpl implements EvidenceService {
    private final EvidenceRepository evidenceRepository;
    private final DamageClaimRepository claimRepository;

    public EvidenceServiceImpl(EvidenceRepository evidenceRepository, DamageClaimRepository claimRepository) {
        this.evidenceRepository = evidenceRepository;
        this.claimRepository = claimRepository;
    }

    @Override
    public Evidence uploadEvidence(Long claimId, Evidence evidence) {
        DamageClaim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("claim not found"));
        evidence.setClaim(claim);
        return evidenceRepository.save(evidence);
    }

    @Override
    public List<Evidence> getEvidenceForClaim(Long claimId) {
        List<Evidence> list = evidenceRepository.findByClaim_Id(claimId);
        // Return empty list if null to satisfy testEvidenceEmptyList
        return (list != null) ? list : new ArrayList<>();
    }
}