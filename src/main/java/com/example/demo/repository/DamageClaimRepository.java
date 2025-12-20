package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.repository.DamageEntity;

public interface DamageClaimRepository extends JpaRepository<DamageClaimEntity, Long> {
    List<DamageClaim> findByParcel_Id(Long parcelId);
}
