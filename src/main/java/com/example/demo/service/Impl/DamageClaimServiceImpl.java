package com.example.demo.service.Impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.UserService;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DamageClaimServiceImpl implements DamageClaimService {

    private final ParcelRepository parcelRepository;
    private final DamageClaimRepository claimRepository;
    private final ClaimRuleRepository ruleRepository;

    
    public DamageClaimServiceImpl(ParcelRepository parcelRepository,
                                  DamageClaimRepository claimRepository,
                                  ClaimRuleRepository ruleRepository) {
        this.parcelRepository = parcelRepository;
        this.claimRepository = claimRepository;
        this.ruleRepository = ruleRepository;
    }

    @Override
    public DamageClaim fileClaim(Long parcelId, DamageClaim claim) {
        Parcel parcel = parcelRepository.findById(parcelId)
                .orElseThrow(() -> new ResourceNotFoundException("Parcel not found"));

        claim.setParcel(parcel);
        claim.setStatus("PENDING");
        return claimRepository.save(claim);
    }

    @Override
    public DamageClaim evaluateClaim(Long claimId) {
        DamageClaim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found"));

        List<ClaimRule> rules = ruleRepository.findAll();
        Set<ClaimRule> appliedRules = new HashSet<>();

        double score = RuleEngineUtil.evaluate(claim, rules, appliedRules);

        claim.setScore(score);
        claim.setAppliedRules(appliedRules);

        if (score > 0.9) {
            claim.setStatus("APPROVED");
        } else if (score == 0.0) {
            claim.setStatus("REJECTED");
        }

        return claimRepository.save(claim);
    }

    @Override
    public DamageClaim getClaim(Long claimId) {
        return claimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found"));
    }
}
