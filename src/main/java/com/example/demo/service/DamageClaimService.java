package com.example.demo.service;

import com.example.demo.model.DamageClaimEntity;

public interface DamageClaimService {
    DamageClaimEntity fileClaim(Long parcelId, DamageClaim claim);
    DamageClaimEntity evaluateClaim(Long claimId);
    DamageClaimEntity getClaim(Long claimId);
}
