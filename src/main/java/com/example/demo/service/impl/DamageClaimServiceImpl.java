package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DamageClaimService;
import com.example.demo.util.RuleEngineUtil;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DamageClaimServiceImpl implements DamageClaimService {
    private final ParcelRepository parcelRepo;
    private final DamageClaimRepository claimRepo;
    private final ClaimRuleRepository ruleRepo;

    public DamageClaimServiceImpl(ParcelRepository parcelRepo, DamageClaimRepository claimRepo, ClaimRuleRepository ruleRepo) {
        this.parcelRepo = parcelRepo;
        this.claimRepo = claimRepo;
        this.ruleRepo = ruleRepo;
    }

    @Override
    public DamageClaim fileClaim(Long parcelId, DamageClaim claim) {
        Parcel p = parcelRepo.findById(parcelId)
                .orElseThrow(() -> new ResourceNotFoundException("parcel not found"));
        claim.setParcel(p);
        claim.setStatus("PENDING");
        return claimRepo.save(claim);
    }

    @Override
    public DamageClaim evaluateClaim(Long claimId) {
        DamageClaim claim = claimRepo.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("claim not found"));
        List<ClaimRule> rules = ruleRepo.findAll();
        
        double score = RuleEngineUtil.computeScore(claim.getClaimDescription(), rules);
        claim.setScore(score);
        
        if (score > 0.9) claim.setStatus("APPROVED");
        else if (score == 0.0) claim.setStatus("REJECTED");
        
        // Add matching rules to appliedRules set
        rules.forEach(r -> claim.getAppliedRules().add(r));
        
        return claimRepo.save(claim);
    }

    @Override
    public DamageClaim getClaim(Long claimId) {
        return claimRepo.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("claim not found"));
    }
}