package com.example.demo.controller;

import com.example.demo.model.DamageClaim;
import com.example.demo.service.DamageClaimService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/claims")
public class DamageClaimController {

    private final DamageClaimService damageClaimService;

    public DamageClaimController(DamageClaimService damageClaimService) {
        this.damageClaimService = damageClaimService;
    }

    @PostMapping("/parcel/{parcelId}")
    public DamageClaim fileClaim(@PathVariable Long parcelId,
                                 @RequestBody DamageClaim claim) {
        return damageClaimService.fileClaim(parcelId, claim);
    }

    @PostMapping("/{claimId}/evaluate")
    public DamageClaim evaluate(@PathVariable Long claimId) {
        return damageClaimService.evaluateClaim(claimId);
    }

    @GetMapping("/{claimId}")
    public DamageClaim getClaim(@PathVariable Long claimId) {
        return damageClaimService.getClaim(claimId);
    }
}
